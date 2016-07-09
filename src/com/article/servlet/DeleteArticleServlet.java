package com.article.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.article.connect.JDBCConnect;

@WebServlet("/DeleteArticleServlet")
public class DeleteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		Connection connection = JDBCConnect.getConnection();
		Statement st;
		try {
			st = connection.createStatement();
			//;
			String sqlDeleteQuery = "delete from article where name = '"+name+"'";
			int i=st.executeUpdate(sqlDeleteQuery);
			if(i==1){
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('Article Deleted Successfully.');");
				   out.println("location='welcomeAdmin.jsp';");
				   out.println("</script>");
				
	        }
			else{
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('No such Article found!!');");
				   out.println("location='WelcomeAdmin.jsp';");
				   out.println("</script>"); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
  }
