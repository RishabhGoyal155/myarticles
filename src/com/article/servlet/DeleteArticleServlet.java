package com.article.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.article.dao.ArticleDao;
import com.article.entity.Article;

@WebServlet("/DeleteArticleServlet")
public class DeleteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteArticleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Article art = new Article();
		art.setName(request.getParameter("name"));
		int status = ArticleDao.Delete(art);

		if (status > 0) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Article Deleted Successfully.');");
			out.println("location='welcomeAdmin.jsp';");
			out.println("</script>");

		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('No such Article found!!');");
			out.println("location='WelcomeAdmin.jsp';");
			out.println("</script>");
		}

	}
}
