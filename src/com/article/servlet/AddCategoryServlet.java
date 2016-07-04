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

@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	//HttpSession session = request.getSession();
    	PrintWriter out = response.getWriter();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		Connection connection = JDBCConnect.getConnection();
		Statement st;
		try {
			st = connection.createStatement();
			//ResultSet rs;
			String sqlInsertQuery = "INSERT INTO category VALUES('"+id+"','"+name+"')";
			System.out.println(sqlInsertQuery);
			int i=st.executeUpdate(sqlInsertQuery);
			System.out.println(i);
			if(i==1){
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('Category Added Successfully.');");
				   out.println("location='WelcomeAdmin.jsp';");
				   out.println("</script>");
				
				//RequestDispatcher rd=request.getRequestDispatcher("success.jsp");  
	             //rd.forward(request,response);
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
