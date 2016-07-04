package com.article.servlet;
import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.article.connect.JDBCConnect;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id=request.getParameter("id");
		session.setAttribute("id", id);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String about=request.getParameter("about");
	    int x=1;
		Connection connection = JDBCConnect.getConnection();
		Statement st;
		try {
			st = connection.createStatement();
			//ResultSet rs;
			String sqlInsertQuery = "INSERT INTO USER VALUES('"+id+"','"+name+"','"+email+
			"','"+password+"','"+about+"','"+x+"')";
			System.out.println(sqlInsertQuery);
			int i=st.executeUpdate(sqlInsertQuery);
			System.out.println(i);
			if(i==1){
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");  
	        rd.forward(request,response);
	        }
			else{
				RequestDispatcher rd=request.getRequestDispatcher("error.jsp");  
		        rd.forward(request,response); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
