<%@page import="java.sql.*,com.article.*,com.article.entity.*"%>
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
if(user!=null && user.getIsAdmin()){
	out.println("<script type=\"text/javascript\">");
	out.println("alert('Author added Successfully.');");
	out.println("location='welcomeAdmin.jsp';");
	out.println("</script>");}
else{
   %>
<div id="header_wrapper">
  <div id="header">   
   	<a href="index.jsp"><div id="site_logo"></div></a>
   		<div id="menu">
		<!-- menu starts -->
      		<div id="menu_left"></div>
            <ul>
               <%if(user!=null){ %>
               <li><a class="current" href="logout.jsp">Log Out </a></li>
               <%} else{%>
               <li><a class="current" href="login.html">Log In </a></li>
               <li><a href="signup.html">Sign UP</a></li>
              <%} %>
               </ul>
           </div> <!-- end of menu -->
         
    </div>  <!-- end of header -->
	
</div> <!-- end of header wrapper -->
         <br><br>
<div id="content_wrapper">
	<div id="content">
    
    <div id="column_w530">	
          <div class="header_02">Signed Up</div>
       <br><br>
       <font size="4px">
You have successfully Signed Up.<br><br/>Now goto <a href="login.html">Login page.</a></font>
<br><br>
            <div class="margin_bottom_20"></div>
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
   %>
	
	</body>
</html>