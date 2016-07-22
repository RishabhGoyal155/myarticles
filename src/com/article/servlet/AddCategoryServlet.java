package com.article.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.article.dao.CategoryDao;
import com.article.entity.Category;
import com.article.entity.User;

@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        User user= (User) session.getAttribute("user");
		
		
		PrintWriter out = response.getWriter();
		Category c = new Category();
		c.setName(request.getParameter("name"));
		int status = CategoryDao.add(c);
		if (status > 0) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Category Added Successfully.');");
			if(user.getIsAdmin()){
				   out.println("location='welcomeAdmin.jsp';");}else{
			   out.println("location='welcome.jsp';");}
			out.println("</script>");

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}
}
