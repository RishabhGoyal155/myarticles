package com.article.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.article.dao.UserDAO;
import com.article.entity.User;

/**
 * Servlet implementation class DeleteAuthorServlet
 */
@WebServlet("/DeleteAuthorServlet")
public class DeleteAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteAuthorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		User u = new User();
		u.setName(request.getParameter("name"));
		int status = UserDAO.delete(u);

		if (status > 0) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Author Deleted Successfully.');");
			out.println("location='welcomeAdmin.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('No such Author exists!!');");
			out.println("location='welcomeAdmin.jsp';");
			out.println("</script>");
		}

		out.println("location='welcomeAdmin.jsp';");
		out.println("</script>");

	}
}
