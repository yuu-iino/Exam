package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter4/hello2"})
public class Hello2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		文字コードUTF-8に指定
		resp.setContentType("text/plain; charset=UTF-8");

		PrintWriter out=resp.getWriter();
		out.println("Hello!");
		out.println("こんにちは！");
		out.println(new java.util.Date());
	}

}
