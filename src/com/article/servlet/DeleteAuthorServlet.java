package com.article.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
        User user= (User) session.getAttribute("user");
		PrintWriter out = response.getWriter();
		int status=0;
		String id[]= request.getParameterValues("deleteId");
		status =UserDAO.Delete(id); 
		out.println("<script type=\"text/javascript\">");
		
			out.println("alert('Author Deleted Successfully.');");
			if(user.getIsAdmin()){
				   out.println("location='welcomeAdmin.jsp';");
		    }else{
			   out.println("location='welcome.jsp';");}
			 
		    out.println("</script>");
	}
	
}
	
