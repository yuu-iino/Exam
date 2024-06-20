package chapter22;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.productDAO;

@WebServlet(urlPatterns={"/chapter22/jstl"})
public class JSTL extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			PrintWriter out=resp.getWriter();
			try {
//				データベースから商品テーブルの全てを参照
				productDAO dao = new productDAO();
				List<Product> list=dao.search("");

//				リクエスト属性に「list」という名前でlistを保持
				req.setAttribute("list", list);

//				attribute2.jspにフォワード
				req.getRequestDispatcher("jstl.jsp").forward(req, resp);

			} catch (Exception e) {
				e.printStackTrace(out);
			}
		}

	}
