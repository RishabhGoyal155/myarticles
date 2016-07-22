<%@page import="com.article.connect.JDBCConnect,java.util.*"%>
<%@page import="java.sql.*,java.io.*,com.article.dao.*,com.article.entity.*,com.article.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
   <link rel="shortcut icon" href="images/logo1.png" />
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <title>MY ARTICLE</title>
      <link href="style.css" rel="stylesheet" type="text/css" />
      <link href="css/style1.css" rel="stylesheet" type="text/css" />
      <script type="text/javascript">
         function clearText(field)
         {
             if (field.defaultValue == field.value) field.value = '';
             else if (field.value == '') field.value = field.defaultValue;
         }
      </script>
   </head>
   <body>
   <% User user= (User) session.getAttribute("user");
   %>
   
      <div id="header_wrapper">
         <div id="header">
            <a href="index.jsp">
               <div id="site_logo"></div>
            </a>
            <div id="menu">
               <!-- menu starts -->
               <div id="menu_left"></div>
               <ul>
               <%if(user!=null){ %>
               <li><a class="current" href="logout.jsp">Log Out </a></li>
               <%} else{%>
               <li><a class="current" href="login.html">Log In </a></li>
               <li><a href="signup.html">Sign UP</a></li>
              <%} %>
               </ul>
            </div>
            <!-- end of menu -->
         </div>
         <!-- end of header -->
      </div>
      <!-- end of header wrapper -->
      <div id="banner_wrapper">
         <div id="banner">
            <div id="banner_image">
               <div id="banner_image_wrapper">
                  <img src="images/image1.jpg" alt="image 1" />
               </div>
            </div>
            <div id="banner_content">
               <div class="header_01">Expert Authors Sharing Their Best Articles </div>
               <p>Share your Article with us, for more traffic, credibility and exposure on your WEBSITE.</p>
       
       <div class="dropdown">
  <button class="dropbtn">Category</button>
  <div class="dropdown-content">        
   <% 
    ArrayList<Category> CatFromDB = CategoryDao.display();
    int cat2;
    for (int i=0; i<CatFromDB.size(); i++){
    	cat2=CatFromDB.get(i).getId();;
     %><a href="categoryArticle.jsp?categ=<%=cat2%>"><%= CatFromDB.get(i).getName() %></a><% 
   }     		   
   %>
  </div>
</div>
            </div>
             <div class="cleaner"></div>
         </div>
         <!-- end of banner -->
      </div>
      <!-- end of banner wrapper -->
      <div id="content_wrapper">
         <div id="content">
            <div id="column_w530">
               <div class="header_02">Welcome to our WEBSITE!</div>
               <p class="em_text">My Articles is an innovative platform that allows experts to share knowledge, expertise, and wisdom.</p>
               <p>Our site is a place for original articles where the author has an exclusive right to the content.</p>
               <div class="margin_bottom_20"></div>
               <ul class="content_list_01">
                  <li>The traffic we send to your site is highly targeted toward your topic. Those visitors want what you're offering!</li>
                  <li>The articles you write and submit may be viewed by the millions of visitors who use our website every month!</li>
               </ul>
               <div class="margin_bottom_20"></div>
               <div class="content_section_01">
                  Our expert content is perfect for email newsletter publishers looking for content they can syndicate for the benefit of their members.We consist of a small, 
                  passionate team of humans that care about providing great service.
               </div>
               <div class="cleaner"></div>
            </div>
            <div id="column_w300">
               <div class="header_03">Latest Articles</div>
               <div class="column_w300_section_01">
                  <div class="news_content">
                     <%
                    ArrayList<Article> artFromDB = ArticleDao.displayAll();
                		  String art2;
                		  if(artFromDB.size()!=0){
                	for (int i=0; i<artFromDB.size(); i++){
                    	  art2=String.valueOf(artFromDB.get(i).getId());
                    	  
                      if(i==0){ %>
                     <div class="header_04"><a href="article.jsp?artic=<%=art2%>" ><%=artFromDB.get(i).getName() %></a></div>
                     <p><%=artFromDB.get(i).getContent()%></p>
                  </div>
                  <div class="cleaner"></div>
               </div>
               <%}if(i==1){ %>
                    <div class="column_w300_section_01 even_color">
                  <div class="news_content">
                     <div class="header_04"><a href="article.jsp?artic=<%=art2%>" ><%=artFromDB.get(i).getName() %></a></div>
                     <p><%=artFromDB.get(i).getContent()%></p>
                  </div>
                  <div class="cleaner"></div>
               </div>
               <%}if(i==2){ %>
               <div class="column_w300_section_01">
                  <div class="news_content">
                     <div class="header_04"><a href="article.jsp?artic=<%=art2%>" ><%=artFromDB.get(i).getName() %></a></div>
                     <p><%=artFromDB.get(i).getContent()%></p>
                  </div> 
                  <div class="cleaner"></div>
               </div>
               <div class="cleaner"></div>
            </div>
            <div class="cleaner"></div>
         </div>
         <%}}}else{
        	 %>
             <div class="header_04">No Article Present</div>
             <p></p>
          </div>
          <div class="cleaner"></div>
       </div>
       <%
         }%>
         <div class="cleaner"></div>
            </div>
            <div class="cleaner"></div>
         </div>
         <!-- end of content wrapper 
      </div>
      <!-- end of content wrapper -->
      <div id="footer_wrapper">
         <div id="footer">
            <div class="margin_bottom_20"></div>
            Copyright Reserved © <a href="#">Myarticles.com</a>  by <a href="#">Rishabh Goyal</a>
            <div class="cleaner"></div>
         </div>
         <!-- end of footer -->
      </div>
      <!-- end of footer -->
   </body>
</html>