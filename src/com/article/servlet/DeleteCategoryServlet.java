package com.article.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.article.dao.CategoryDao;
import com.article.entity.Category;
import com.article.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DeleteCategoryServlet")
public class DeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteCategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        User user= (User) session.getAttribute("user");
		
		PrintWriter out = response.getWriter();
		int status=0;
		String id[]= request.getParameterValues("deleteId");
		for(int i=0;i<id.length;i++){
			int categoryId = Integer.parseInt(id[i]); 
			Category category = new Category();
			category.setId(categoryId);
			status =CategoryDao.delete(category); 
		}
		
		out.println("<script type=\"text/javascript\">");
		
		if (status > 0) {
			out.println("alert('Category Deleted Successfully.');");
			if(user.getIsAdmin()){
				   out.println("location='welcomeAdmin.jsp';");}else{
			   out.println("location='welcome.jsp';");}
			 out.println("</script>");
		} else {
			out.println("alert('Some error has occured!!');");
			out.println("location='error.jsp';");}
		    out.println("</script>");
			}


	}
