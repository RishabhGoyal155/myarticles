package com.article.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import com.article.dao.CategoryDao;
import com.article.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteCategoryServlet")
public class DeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteCategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Category c = new Category();
		c.setName(request.getParameter("name"));
		int status = CategoryDao.delete(c);

		out.println("<script type=\"text/javascript\">");
		if (status > 0) {
			out.println("alert('Category Deleted Successfully.');");
		} else {
			out.println("alert('No such Category exists!!');");
		}
		out.println("location='welcomeAdmin.jsp';");
		out.println("</script>");

	}
}
