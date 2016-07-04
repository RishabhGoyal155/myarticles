<%@page import="java.sql.*,com.article.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
            <div class="header_02">Details</div>
             <br><br>
             <%@page import="java.sql.*,javax.sql.*" %>
<%
String id=(String)session.getAttribute("id");
Class.forName("com.mysql.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/myarticles",
		"root","password");
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("select * from user where id = '"+id+"'");
if(!rs.next()) {
	// New location to be redirected
	   String site = new String("error.jsp");
	   response.setStatus(response.SC_MOVED_TEMPORARILY);
	   response.setHeader("Location", site); 
} else {
%>
<strong>ID :</strong> 
   <%= rs.getString(1) %><br><br>
              
<strong>  Name :</strong><%= rs.getString(2) %><br><br>
<strong>  Email :</strong> <%= rs.getString(3) %> <br><br>
<strong>  About :</strong> <%= rs.getString(5) %> <br><br>
  
<%
  }
%>
<form>
<input type="button" value="Back" 
 onClick="history.go(-1);return true;"> 
</form>
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