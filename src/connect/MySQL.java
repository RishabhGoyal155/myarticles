package connect;

import java.sql.*;

public class MySQL {
	public static Connection connect(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			return DriverManager.getConnection("jdbc:mysql://localhost/MyArticles",
					"root","password");
		}
		catch(Exception e){
			return null;
		}
	}
	
	public static boolean close(Connection c) {
		try{
			c.close();
			return true;
	        }
	      catch(Exception e){
		   return false;
	    }
    }
}