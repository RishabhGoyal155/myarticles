package com.article.servlet;

import com.article.connect.JDBCConnect;
import com.article.entity.User;

import java.sql.*;

public class DAO {

public static int register(User u){  
int status=0;  
try{  
Connection con=JDBCConnect.getConnection();
PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?,?)");  
ps.setString(1,u.getId());  
ps.setString(2,u.getName());  
ps.setString(3,u.getEmail());  
ps.setString(4,u.getPassword());
ps.setString(5,u.getAbout());
ps.setBoolean(6,u.getIsAdmin());

status=ps.executeUpdate();  
}catch(Exception e){}  
      
return status;  
}  


public static boolean validate(User bean){  
boolean status=false;  
try{  
Connection con=JDBCConnect.getConnection();              
PreparedStatement ps=con.prepareStatement(  
    "select * from user where id=? and password=?");  
  
ps.setString(1,bean.getId());  
ps.setString(2, bean.getPassword());  
              
ResultSet rs=ps.executeQuery();  
status=rs.next();                
}
catch(Exception e){}  

return status;  
  
}  





}
