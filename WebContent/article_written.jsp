<%@page import="com.article.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
				<div class="header_02">Your Articles</div>
				<br>
				<br>
				<%@page import="java.sql.*,javax.sql.*"%>
				<%
					String id = (String) session.getAttribute("id");
					int i = 1;
					//session.putValue("id", id);
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/myarticles", "root",
							"password");
					Statement st = c.createStatement();
					String sqlSelectQuery = "select author from user where id = '" + id
							+ "'";
					String sqlSelectQuery1 = "select name from article where author_id = '"
							+ id + "'";
					String sqlSelectQuery2 = "select name from article order by name";
					ResultSet rs1 = st.executeQuery(sqlSelectQuery);
					if (rs1.next()) {
						rs1.beforeFirst();
						i = rs1.getInt(1);
					}
					if (i == 1) {
						ResultSet rs = st.executeQuery(sqlSelectQuery1);
						if (!rs.next()) {
							out.println("You have not written any article yet.");
						} else {
							rs.beforeFirst();
							while (rs.next()) {
				%>

				<%=rs.getString(1)%><br>
				<%
					}
						}
					} else {

						ResultSet rs = st.executeQuery(sqlSelectQuery2);
						if (!rs.next()) {
							out.println("You have not written any article yet.");
						} else {
							rs.beforeFirst();
							while (rs.next()) {
				%>

				<%=rs.getString(1)%><br>
				<%
					}
						}
					}
				%>
				<br>
				<br> <br>
				<br>
				<br>
				<form>
					<input type="button" value="Back"
						onClick="history.go(-1);return true;">
				</form>
				<br>
				<br>
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
</body>
</html>