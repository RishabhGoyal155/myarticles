<%@page import="java.sql.*,com.article.entity.*,com.article.dao.*,com.article.*,java.util.*"%>
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
<link href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/css/bootstrap.min.css"
   rel="stylesheet" type="text/css" />
   <link href="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/css/bootstrap-multiselect.css"
   rel="stylesheet" type="text/css" />
  
<body>
<%User user= (User) session.getAttribute("user");
   if(user!=null){ %>
 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
 
  <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
   <script src="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/js/bootstrap-multiselect.js"
    type="text/javascript"></script>
   <script type="text/javascript">
     $(function () {
     $('#category').multiselect({
     includeSelectAllOption: true
     });
     });
    </script>
<div id="header_wrapper">
  <div id="header">   
   	<a href="index.jsp"><div id="site_logo"></div></a>
   	<div id="menu">
	<!-- menu starts -->
	<div id="menu_left"></div>
    <ul>
    <li><a class="current" href="logout.jsp">Log Out..</a></li>
    </ul>    	
	</div> <!-- end of menu -->
    </div>  <!-- end of header -->
	</div> <!-- end of header wrapper -->
       <br><br><br>
<div id="content_wrapper">
	<div id="content">
    
    	<div id="column_w530">	
            <div class="header_02">New Article</div>
    <form action="AddArticleServlet" method="post" name="article" >
               <table>
            <tr height="50">
      <td align="right">Category:</td>
      <td align="left"><select id="category" multiple="multiple" name="category">
        <% 
    ArrayList<Category> CatFromDB = CategoryDao.display();
    
    for (int i=0; i<CatFromDB.size(); i++){
     %><option value="<%=CatFromDB.get(i).getName()%>"><%= CatFromDB.get(i).getName() %></option>
     <%}%>
    </select></td>
    </tr>
    
             <tr height="50">
      <td align="right">Heading:</td>
      <td align="left"><input type="text" required="required" name="name" /></td>
    </tr>
    <tr height="50" >
      <td align="right" rowspan="10" >Content:</td>
    <td><textarea name="content" required="required"  cols="23" rows="11"></textarea></td>
    </tr>
  </table>
<br>
&emsp;&emsp;&emsp;&emsp; <button  type="submit">Submit  Article!</button>
</form>
<form><br>
&nbsp;&emsp;&emsp;&emsp;&emsp;
<input type="button" value="Back" onClick="history.go(-1);return true;"> 
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
        Copyright Reserved © <a href="index.jsp">Myarticles.com</a>  by <a href="#">Rishabh Goyal</a>
        <div class="cleaner"></div>
    </div> <!-- end of footer -->
	</div> <!-- end of footer -->
		
	<%}
   else
   {
	   out.println("<script type=\"text/javascript\">");
	   out.println("alert('You have not logged in properly.Please try again.');");
	   out.println("location='index.jsp';");
	   out.println("</script>");
   }
   %></body>
</html>