package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

public class productDAO extends DAO {
//商品名で検索するメソッド
	public List<Product> search(String keyword) throws Exception {
//		Productを要素に持つList
		List<Product> list = new ArrayList<Product>();
		Connection con = getConnection();

		// データベースを使った処理を記述

		PreparedStatement st = con.prepareStatement(
				"select * from product where name like ?");
		st.setString(1, "%" + keyword + "%");
		ResultSet rs = st.executeQuery();

		// 結果から1件ずつ取り出すループ
		while(rs.next()){
//			Productクラスをインスタンス化
			Product p = new Product();

			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
//			リストに追加
			list.add(p);
		}

		// データベースとの接続を解除（必ず書く！！！！！！！！）
		st.close();
		con.close();

		return list;
	}
//全ての商品を参照するメソッド
	public List<Product> all() throws Exception {
//		Productを要素に持つList
		List<Product> list = new ArrayList<Product>();
		Connection con = getConnection();

		// データベースを使った処理を記述

		PreparedStatement st = con.prepareStatement(
				"select * from product");
		ResultSet rs = st.executeQuery();

		// 結果から1件ずつ取り出すループ
		while(rs.next()){
//			Productクラスをインスタンス化
			Product p = new Product();

			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
//			リストに追加
			list.add(p);
		}

		// データベースとの接続を解除（必ず書く！！！！！！！！）
		st.close();
		con.close();

		return list;
	}
	public Product get(int id)throws Exception {
		Product p = new Product();
		Connection con = getConnection();

		// データベースを使った処理を記述

		PreparedStatement st = con.prepareStatement(
				"select * from product where id = ?");
		st.setInt(1,id);
		ResultSet rs = st.executeQuery();

		// 結果から1件取り出す
		if(rs.next()){
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
		}else {
			p = null;
		}

		// データベースとの接続を解除（必ず書く！！！！！！！！）
		st.close();
		con.close();

		return p;
	}
//商品を登録するメソッド
	public int insert(Product product) throws Exception {
		Connection con = getConnection();

		// データベースを使った処理を記述

		PreparedStatement st = con.prepareStatement(
				"insert into product values(null, ?, ?)");
		st.setString(1,product.getName());
		st.setInt(2, product.getPrice());
		int line=st.executeUpdate();


		// データベースとの接続を解除（必ず書く！！！！！！！！）
		st.close();
		con.close();

		return line;
	}

}
