<%@page import="java.sql.*,com.article.*,java.util.*,com.article.dao.*,java.io.*,com.article.entity.*"%>
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
   if(user!=null && user.getIsAdmin()){ %>
	<div id="header_wrapper">
		<div id="header">
			<a href="index.jsp"><div id="site_logo"></div></a>
			<div id="menu">
				<!-- menu starts -->
				<div id="menu_left"></div>
				<ul>
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
				<div class="header_02">Add Category</div>
				<br> <br>
				<font size="3px">Existing Categories:&emsp;
				<% 
    ArrayList<Category> catFromDB = CategoryDao.display();
    String cat2;
    for (int i=0; i<catFromDB.size(); i++){if(i+1==catFromDB.size()){
     %><%= catFromDB.get(i).getName() %><% 
   }     		   
    else{
    	if((i+1)%4==0){%><br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<%}
    	%><%= catFromDB.get(i).getName() %>,&emsp;<%
    }
    }
   %></font>
				<form action="AddCategoryServlet" method="post" name="AddCategory">
					<br><br>
					<table>
						<tr>
							<td align="right">Category Name:</td>
							<td align="left"><input type="text" required="required"
								name="name" /></td>
						</tr>
					</table>
					<br> <br>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<button type="submit">Add Category!</button>
					<br>
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