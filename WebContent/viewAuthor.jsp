<%@page import="com.article.connect.JDBCConnect,java.util.*"%>
<%@page import="java.sql.*,java.io.*,com.article.dao.*,com.article.entity.*,com.article.*"%>
<%@page import="java.sql.*,com.article.*,com.article.entity.*,java.io.*"%>
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
<script type="text/javascript">

function valthisform()
{
	var chk = document.getElementsByName('deleteId')
	var len = chk.length

	for(i=0;i<len;i++)
	{
	     if(chk[i].checked){
	    return true;
	      }
	}
	return false;

}

 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }
 
 function validateEdit()
 {
 	var chk = document.getElementsByName('deleteId')
 	var len = chk.length
 	var c=0
 	for(i=0;i<len;i++)
 	{
 	     if(chk[i].checked){
 	    c=c+1;
 	      }
 	}
 	if(c==1){return true;}
 	else{return false;}
     
 	}
</script>   
</head>

<body>
<% User user= (User) session.getAttribute("user");
   if(user!=null && user.getIsAdmin()){ 
    ArrayList<User> userFromDB = UserDAO.displayAll(); 
%> 

	<div id="header_wrapper">
		<div id="header">
			<a href="index.jsp"><div id="site_logo"></div></a>
			<div id="menu">
				<!-- menu starts -->
				<div id="menu_left"></div>
				<ul>
				<li><a class="current" href="welcomeAdmin.jsp"><%=user.getName()%> </a></li>
					<li><a href="logout.jsp">Logout..</a></li>
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
				<div class="header_02">Authors</div>
				<br><br>
				<form action="DeleteAuthorServlet"  method="post" name="DeleteAuthor" id="DeleteAuthor">
	       <br><br><br>
	<table >
	<thead>
<tr>
<td></td>
<th>User Name</th>
<th>Name</th>
<th>Email</th>
<th >About</th>
</tr>
</thead>
<tbody>
<%
   
   int userid;
    for (int ix=0; ix<userFromDB.size(); ix++){
    userid=userFromDB.get(ix).getId();
    if(ix%2==0){
     %>
<tr style="background-color: #9ACD32">
<%}else{%>
<tr>
<%} %>
<td>
<input type="checkbox" name="deleteId" value="<%=userid%>"/>
</td>
<td><%=userFromDB.get(ix).getUsername()%></td>
<td><%=userFromDB.get(ix).getName()%></td>
<td><%=userFromDB.get(ix).getEmail()%></td>
<td><%=userFromDB.get(ix).getAbout()%> </td>
 </tr>
<%}
%>
</tbody>
</table>
<br><br> <br><br>
<input type="button" value="Add New" name="Add new" onclick="openPage('signup.html')">
&emsp;
<input type="submit" value="Delete" onclick="return valthisform();" >&emsp;
<input type="button" value="Back" 
 onClick="history.go(-1);return true;">			
 			</form>
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
	   out.println("alert('You cannot access admin functionalities.');");
	   out.println("location='index.jsp';");
	   out.println("</script>");
   }
   %>
</body>
</html>