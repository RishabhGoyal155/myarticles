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
 <%String id=(String)session.getAttribute("id");
 %>          
       <form action="successArticle.jsp" method="post" name="article" >
               <table>
             <tr height="50">
      <td align="right">Heading:</td>
      <td align="left"><input type="text" required="required" name="name" /></td>
    </tr>
    <tr height="50">
      <td align="right">Article id:</td>
      <td align="left"><input type="text" required="required" name="id" /></td>
    </tr>
    <tr height="50">
      <td align="right">Category:</td>
      <td align="left"><select size="5px"></td>
    </tr>
    <tr height="50" >
      <td align="right" rowspan="10" >Content:</td>
    <td align="left" colspan="5" rowspan="5">
    <input height="100" width="100" type="text" required="required" name="content" />
    </td>
    </tr>
  </table>
  
  
<center><br> <button  type="submit">Save & Submit!</button></center>

</form>
<form><center><br>
<input type="button" value="Back" 
 onClick="history.go(-1);return true;"> </center>
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
        Copyright Reserved � <a href="index.jsp">Myarticles.com</a>  by <a href="#">Rishabh Goyal</a>
        <div class="cleaner"></div>
    </div> <!-- end of footer -->
	</div> <!-- end of footer --></body>
</html>