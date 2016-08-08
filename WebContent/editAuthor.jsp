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
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}

function validate(form) {
	  var e = form.elements;
 if(e['password'].value != e['confirm_password'].value) {
	    alert('Password and confirm password does not match.');
	    return false;
	  }
	  return true;
	}
</script>
</head>

<body>
<% User user= (User) session.getAttribute("user");
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
                <li><a class="current" href="welcome.jsp"><%=user.getName()%> </a></li><%} %>
               <li><a href="logout.jsp">Log Out </a></li>
               <%} else{%>
               <li><a class="current" href="login.html">Log In </a></li>
               <li><a href="signup.html">Sign Up</a></li>
              <%} %>
               </ul>   	
		</div> <!-- end of menu -->
    </div>  <!-- end of header -->
</div> <!-- end of header wrapper -->
<br><br><br>
<div id="content_wrapper">
	<div id="content">
    <div id="column_w530">	
            <div class="header_02">Edit Details</div>
             <br><br>
           <fieldset>  <form action="EditUserServlet" method="post" name="signin" onsubmit="return validate(this);" >
     <br> 
             <table>   
    <tr>
      <td align="right"> Name:</td>
      <td align="left"><input type="text" size="21"
       required="required" name="name" value="<%=user.getName() %>" /></td>
    </tr>
     <tr>
      <td align="right">Email:</td>
      <td align="left"><input type="email" size="21"
       required="required" name="email" value="<%=user.getEmail()%>"/></td>
    </tr>
    <tr>
      <td align="right">About:</td>
      <td><textarea name="about" required="required" cols="17" rows="5">
      <%=user.getAbout() %></textarea></td>
      </tr>
  </table>
  <br>&emsp;&emsp;&emsp;&emsp;
  <button type="submit">  Save Changes!</button>
  
  
</form> 
<form><br>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
<input type="button" value="Back" 
 onClick="history.go(-1);return true;"> 
</form>
</fieldset>
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