<%@page import="com.article.dao.ArticleDao"%>
<%@page import="java.sql.*,com.article.*"%>
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
<%User user= (User) session.getAttribute("user");
 String art1=request.getParameter("artic");
   if(art1 != null) {
	   Article article=ArticleDao.validate(art1);
%>
	<div id="header_wrapper">
		<div id="header">
			<a href="index.jsp"><div id="site_logo"></div></a>
			<div id="menu">
				<!-- menu starts -->
				<div id="menu_left"></div>
				<ul>
               <%if(user!=null){ if(user.getIsAdmin()){%>
               <li><a class="current" href="welcomeAdmin.jsp"><%=user.getName()%> </a></li>
               <%}else{%>
                <li><a class="current" href="welcome.jsp"><%=user.getName()%> </a></li>
              <%} %>
               <li><a href="logout.jsp">Log Out </a></li>
               <%} else{%>
               <li><a class="current" href="login.html">Log In </a></li>
               <li><a href="signup.html">Sign Up</a></li>
              <%} %>
               </ul>
</div>
<!-- end of menu -->
</div>
<!-- end of header -->
</div>
<!-- end of header wrapper -->
	<br><br><br>
	<div id="content_wrapper">
		<div id="content">
			<div id="column_w530">
				<div class="header_02">
					<%@page import="com.article.entity.*"%>
					<%	out.println(article.getName());
					%>
				</div>
				
				<br><br>
				<p style="font-size: 20px"><%=article.getContent()%>
				</p> 
				<br><br><br><br><form>
<input type="button" value="Back" 
 onClick="history.go(-1);return true;"> 
</form>
<br><br><br><br><br>
			</div><%session.removeAttribute("article"); %>
			<br><br>
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
	   //out.println("alert('There is some problem in displaying this a.');");
	   out.println("location='error.jsp';");
	   out.println("</script>");
   }
   %>
</body>
</html>