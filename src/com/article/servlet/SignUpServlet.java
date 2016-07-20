package com.article.servlet;

import java.io.IOException;
//import java.sql.*;
//import com.article.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.article.dao.UserDAO;
//import com.article.connect.JDBCConnect;
import com.article.entity.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setId(request.getParameter("id"));
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setAbout(request.getParameter("about"));
		user.setPassword(request.getParameter("password"));
		user.setIsAdmin(false);

		int status = UserDAO.register(user);
		if (status > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}

	}

}
