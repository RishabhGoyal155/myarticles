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
import com.article.entity.Article;
import com.article.entity.User;
/**
 * Servlet implementation class AddArticleServlet
 */
@WebServlet("/AddArticleServlet")
public class AddArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/** 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		
		PrintWriter out = response.getWriter();
		
		//Get the system date and time.
				java.util.Date utilDate = new java.util.Date();
				//Convert it to java.sql.Date
				java.sql.Date rdate = new java.sql.Date(utilDate.getTime());
		
		User user= (User) session.getAttribute("user");
		Article article=new Article();
		article.setName(request.getParameter("name"));
		article.setContent(request.getParameter("content"));
		String categ[] =request.getParameterValues("category");
		article.setAuthor_name(user.getUsername());
        article.setDate(rdate);
		int status=ArticleDao.add(article,categ,user); 
		if(status>0)  {
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Article is submitted.');");
			   if(user.getIsAdmin()){
				   out.println("location='welcomeAdmin.jsp';");}else{
			   out.println("location='welcome.jsp';");}
			   out.println("</script>");
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");  
		    rd.forward(request,response); 
		}	
	}

}
