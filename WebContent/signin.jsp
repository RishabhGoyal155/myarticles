<%@page import="java.sql.*,connect.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Signin</title>
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
        <br><br>
<div id="content_wrapper">
	<div id="content">
    
 <%@page import="java.sql.*,javax.sql.*" %>
<%
String id=request.getParameter("id");
session.setAttribute("id", id);
String name=request.getParameter("name");
String email=request.getParameter("email");
String password=request.getParameter("password");
String about=request.getParameter("about");
int x=Integer.parseInt(request.getParameter("author"));
Class.forName("com.mysql.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/myarticles",
		"root","mysql");
Statement st=c.createStatement();
ResultSet rs;
String sqlInsertQuery = "INSERT INTO USER VALUES('"+id+"','"+name+"','"+email+
"','"+password+"','"+about+"','"+x+"')";
System.out.println(sqlInsertQuery);

int i=st.executeUpdate(sqlInsertQuery);
%>

   	<div id="column_w530">	
            <div class="header_02">Welcome
            <% out.print(id);%>
            </div>
             <br><br>
             <p style="font-size:20px"><a href="details.jsp" >Details</a></p><br>
<p style="font-size:20px"><a href="write_new.html">Write new Article</a></p><br>
             <br><br><br>
             
<%
out.print("You are now a registered author.");
 %>             
             
             
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