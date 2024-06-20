package chapter23;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.productDAO;
import tool.Action;

public class SearchAction extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String keyword=req.getParameter("keyword");

		productDAO dao=new productDAO();
		List<Product> list=dao.search(keyword);

		req.setAttribute("list", list);

		return "list.jsp";
	}

}
