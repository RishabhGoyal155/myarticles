package com.article.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.article.dao.UserDAO;
import com.article.entity.User;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		  User user= (User) session.getAttribute("user");
			user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setAbout(request.getParameter("about"));
		
		int status = UserDAO.update(user);
		RequestDispatcher rd;
		if (status > 0) {
			if(user.getIsAdmin()){
			 rd = request.getRequestDispatcher("welcomeAdmin.jsp");
			}else{
			 rd = request.getRequestDispatcher("welcome.jsp");	
			}
			rd.forward(request, response);
		} else {
			 rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		
	}

}
