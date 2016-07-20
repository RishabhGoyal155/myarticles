<%@page import="com.sun.xml.internal.fastinfoset.util.StringArray"%>
<%@page import="com.article.entity.*,com.article.dao.*"%>
<%@page import="java.sql.*,com.article.*,com.article.connect.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="shortcut icon" href="images/logo1.png" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MY ARTICLES</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>
</head>

<body>
<%User user= (User) session.getAttribute("user");
   if(user!=null){ %>

<div id="header_wrapper">
  <div id="header">   
   	<a href="index.jsp"><div id="site_logo"></div></a>
   		<div id="menu">
		<!-- menu starts -->
      		<div id="menu_left"></div>
            <ul>
                  <li><a href="logout.jsp">Logout..</a></li>
            </ul>    	
        </div> <!-- end of menu -->
      </div>  <!-- end of header -->
	
</div> <!-- end of header wrapper -->
         <br><br>
<div id="content_wrapper">
	<div id="content">
    
      
 <%@page import="java.sql.*,javax.sql.*" %>
<%
Article art=new Article();
art.setName(request.getParameter("name"));
art.setId(request.getParameter("article_id"));
art.setContent(request.getParameter("content"));
String categ[] =request.getParameterValues("category");
art.setAuthorId(user.getId());

//Get the system date and time.
java.util.Date utilDate = new java.util.Date();
//Convert it to java.sql.Date
java.sql.Date rdate = new java.sql.Date(utilDate.getTime());
art.setDate(rdate);
int status=ArticleDao.add(art,categ); 
if(status>0)  {
	out.println("<script type=\"text/javascript\">");
	   out.println("alert('Article is submitted.');");
	   out.println("location='welcome.jsp';");
	   out.println("</script>");
}
else{
	RequestDispatcher rd=request.getRequestDispatcher("error.jsp");  
    rd.forward(request,response); 
}
%>          <div class="margin_bottom_20"></div>
            <div class="margin_bottom_20"></div>           
           <div class="cleaner"></div>
        </div>
    <div class="cleaner"></div>
    </div> <!-- end of content wrapper -->
</div> <!-- end of content wrapper -->

<div id="footer_wrapper">
    <div id="footer">
          
        <div class="margin_bottom_20"></div>
        Copyright Reserved © <a href="#">Myarticles.com</a>  by <a href="#">Rishabh Goyal</a>
        <div class="cleaner"></div>
    </div> <!-- end of footer -->
	</div> <!-- end of footer -->
	<%}
   else
   {
	   out.println("<script type=\"text/javascript\">");
	   out.println("alert('Login first.');");
	   out.println("location='index.jsp';");
	   out.println("</script>");
   }
   %>
	
	</body>
</html>