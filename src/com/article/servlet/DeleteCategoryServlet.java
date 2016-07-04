package com.article.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import com.article.connect.JDBCConnect;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		Connection connection = JDBCConnect.getConnection();
		Statement st;
		try {
			st = connection.createStatement();
			//;
			String sqlDeleteQuery = "delete from category where name = '"+name+"' or id = '"+name+"'";
			System.out.println(sqlDeleteQuery);
			int i=st.executeUpdate(sqlDeleteQuery);
			System.out.println(i);
			out.println("<script type=\"text/javascript\">");
			if(i==1){
				   out.println("alert('Category Deleted Successfully.');");
	        }
			else{
				   out.println("alert('No such Category exists!!');");
			}
			   out.println("location='WelcomeAdmin.jsp';");
			   out.println("</script>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  }
