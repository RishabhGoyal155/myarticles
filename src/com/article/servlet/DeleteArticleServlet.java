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

import com.article.dao.ArticleDao;
import com.article.entity.User;
@WebServlet("/DeleteArticleServlet")
public class DeleteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteArticleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        User user= (User) session.getAttribute("user");
		
    		PrintWriter out = response.getWriter();
	    	int status=0;
    if(request.getParameter("Delete") != null){
	    	String id[]= request.getParameterValues("deleteId");
		    status=ArticleDao.Delete(id);
		    out.println("<script type=\"text/javascript\">");
			
	
			out.println("alert('Article Deleted Successfully.');");
			if(user.getIsAdmin()){
				   out.println("location='welcomeAdmin.jsp';");}else{
			   out.println("location='welcome.jsp';");}
			 out.println("</script>");
			
	}
	   else if(request.getParameter("Edit")!=null){
		   String id=request.getParameter("deleteId");
		   session.setAttribute("articleId", id);
		   RequestDispatcher rd;
		   rd = request.getRequestDispatcher("editArticle.jsp");
			rd.forward(request, response);
		  
	   }

	}
}
	

