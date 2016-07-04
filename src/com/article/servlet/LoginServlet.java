package com.article.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.article.connect.JDBCConnect;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id=request.getParameter("id");
		session.setAttribute("id", id);
		String password=request.getParameter("password");
		PrintWriter out = response.getWriter();
		Connection connection = JDBCConnect.getConnection();
		Statement st;
		try {
		st = connection.createStatement();
		String sqlSelectQuery = "select author from user where id = '"+id+"' and password='"+password+"'";
			System.out.println(sqlSelectQuery);
			ResultSet i=st.executeQuery(sqlSelectQuery);
			int s;
			System.out.println(i);
			if(i.next()){
				s=i.getInt(1);
				if(s==1){
			 RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
			 rd.forward(request,response);}
				else{
					 RequestDispatcher rd=request.getRequestDispatcher("WelcomeAdmin.jsp");  
					 rd.forward(request,response);
				}
			}
			else
			{
				//out.print("Sorry user id or password error"); 
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('User or password incorrect');");
				   out.println("location='login.html';");
				   out.println("</script>");
		       // RequestDispatcher rd=request.getRequestDispatcher("login.html");  
		        //rd.include(request,response);  
				
			}
				
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
