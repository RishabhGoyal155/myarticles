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
            <div class="header_02">Welcome 
     <%@page import="java.sql.*,javax.sql.*" %>
<%
String id=(String)session.getAttribute("id");
out.println(id);
%>
</div>
<p style="font-size:20px"><a href="details.jsp" >Details</a></p><br>
<p style="font-size:20px"><a href="writeArticle.jsp">Add Article</a></p><br>
<p style="font-size:20px"><a href="signup.html">Add Author</a></p><br>
<p style="font-size:20px"><a href="addCategory.html" >Add Category</a></p><br>
<p style="font-size:20px"><a href="deleteArticle.html">Delete article</a></p><br>
<p style="font-size:20px"><a href="deleteAuthor.html">Delete author</a></p><br>
<p style="font-size:20px"><a href="deleteCategory.html" >Delete Category</a></p><br>
<p style="font-size:20px"><a href="articleList.jsp">See articles</a></p><br>

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