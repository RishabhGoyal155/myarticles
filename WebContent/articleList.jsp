<%@page import="com.article.connect.JDBCConnect,java.util.*"%>
<%@page import="java.sql.*,java.io.*,com.article.dao.*,com.article.entity.*,com.article.*"%>
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
	function clearText(field) {
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
	}
</script>

</head>

<body>
<% User user= (User) session.getAttribute("user");
   if(user!=null && user.getIsAdmin()){ %>
	<div id="header_wrapper">
		<div id="header">
			<a href="index.jsp"><div id="site_logo"></div></a>
			<div id="menu">
				<!-- menu starts -->
				<div id="menu_left"></div>
				<ul>
				<li><a class="current" href="welcomeAdmin.jsp"><%=user.getName()%> </a></li>
                <li><a href="logout.jsp">Log Out</a></li>
				</ul>
			</div>
			<!-- end of menu -->
		</div>
		<!-- end of header -->
	</div>
	<!-- end of header wrapper -->
	<br>
	<br>
	<br>
	<div id="content_wrapper">
		<div id="content">
        <div id="column_w530">
				<div class="header_02">Articles</div>
				<br> <br>
				<%@page import="java.sql.*,java.io.*,com.article.*"%>
				<%@page import="com.article.connect.JDBCConnect"%>
<%
    ArrayList<Article> artFromDB = ArticleDao.displayAll();
   int art2;
   if(artFromDB.size()==0){%><font size="5px">You have not written any article.</font><br><br><br><br><%}
   else{ for (int i=0; i<artFromDB.size(); i++){
    	art2=artFromDB.get(i).getId();
     %>
    <font size="5px"><a href="article.jsp?artic=<%=art2%>" >
    <%=artFromDB.get(i).getName()%>
    </a><br><br>
    </font>
    <%}}%>
 <br><br>
 <form>
<input type="button" value="Back" 
 onClick="history.go(-1);return true;"> 
</form><br> <br>
				<div class="margin_bottom_20"></div>
				<div class="margin_bottom_20"></div>
				<div class="cleaner"></div>
			</div>
			<div class="cleaner"></div>
		</div>
		<!-- end of content wrapper -->
	</div>
	<!-- end of content wrapper -->

	<div id="footer_wrapper">
		<div id="footer">

			<div class="margin_bottom_20"></div>
			Copyright Reserved © <a href="#">Myarticles.com</a> by <a href="#">Rishabh
				Goyal</a>
			<div class="cleaner"></div>
		</div>
		<!-- end of footer -->
	</div>
	<!-- end of footer -->
	
	<%}
   else
   {
	   out.println("<script type=\"text/javascript\">");
	   out.println("alert('You don't have permission to access this page.');");
	   out.println("location='index.jsp';");
	   out.println("</script>");
   }
   %>
</body>
</html>