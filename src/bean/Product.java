package bean;

import java.io.Serializable;

//Productクラス...productテーブルを表す
public class Product implements Serializable {
//	フィールド...テーブルの列を表す
	private int id;
	private String name;
	private int price;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return name+"("+price+"円)";
	}

	public int getTaxPrice() {
		return (int)(price*1.1);
	}

}
