<%@page import="java.sql.*,connect.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
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
         <br><br><br>
  
<div id="content_wrapper">
	<div id="content">
    
    	<div id="column_w530">	
            <div class="header_02">
     <%@page import="java.sql.*,javax.sql.*" %>
<%
String id=request.getParameter("id");
session.setAttribute("id", id);
String password=request.getParameter("password");
String site = new String("details.jsp");

Class.forName("com.mysql.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/myarticles",
		"root","mysql");
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("select * from user where id = '"+id+"'");
if(rs.next()) 
{ 
if(rs.getString(4).equals(password)) 
{ 
	out.println("Welcome "+id); 
%>
</div>
<p class="em_text" style="font-size:20px"><br><br>Category: </p><br>
<p style="font-size:20px"><a href="details.jsp" >Details</a></p><br>
<p style="font-size:20px"><a href="article_written.jsp">Articles Written by you.</a></p><br>
<p style="font-size:20px"><a href="try.jsp">Write new Article</a></p><br>

<%	
} 
else 
{ 
out.println("Invalid password try again"); 
%>
</div>
<a href="login.html">Login</a>
<% 		
} 
} 
else 
%>
</div>
       
  
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
	</div> <!-- end of footer --></body>
</html>