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

 <link href="css/multi-select.css" rel="stylesheet" type="text/css">
    <link href="css/application.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">

      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-23068623-1']);
      _gaq.push(['_setDomainName', '.loudev.com']);
      _gaq.push(['_trackPageview']);

      (function() {
        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
      })();

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
    
    <tr height="50" >
      <td align="right" rowspan="10" >Content:</td>
    <td align="left" colspan="5" rowspan="5">
    <input height="100" width="100" type="text" required="required" name="content" />
    </td>
    </tr>
  </table>
  
  <div class='simple'>
                <select multiple='multiple' class='multiselect' id='simpleCountries'>
                  <option value='fr'>France</option>
                  <option value='ca'>Canada</option>
                  <option value='ar'>Argentina</option>
                  <option value='pt'>Portugal</option>
                  <option value='us'>United States</option>
                  <option value='gb'>United Kingdom</option>
                  <option value='au'>Australia</option>
                  <option value='ao'>Angola</option>
                  <option value='aq'>Antarctica</option>
                  <option value='bq'>Burkina Faso</option>
                  <option value='cn'>China</option>
                </select>
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/jquery.multi-select.js" type="text/javascript"></script>
    <script src="js/application.js" type="text/javascript"></script>
  </div>
  
  
  
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
        Copyright Reserved © <a href="index.jsp">Myarticles.com</a>  by <a href="#">Rishabh Goyal</a>
        <div class="cleaner"></div>
    </div> <!-- end of footer -->
	</div> <!-- end of footer --></body>
</html>