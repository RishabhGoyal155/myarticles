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

import com.article.dao.UserDAO;
import com.article.entity.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		User user = new User();
		user.setId(request.getParameter("id"));
		user.setPassword(request.getParameter("password"));
		PrintWriter out = response.getWriter();
		RequestDispatcher rd;
		User userFromDB = UserDAO.validate(user);

		if (userFromDB != null) {
			session.setAttribute("user", userFromDB);
			if (!userFromDB.getIsAdmin()) {
				rd = request.getRequestDispatcher("welcome.jsp");
			} else {
				rd = request.getRequestDispatcher("welcomeAdmin.jsp");
			}
			rd.forward(request, response);
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User or password incorrect');");
			out.println("location='login.html';");
			out.println("</script>");
		}
	}
}
