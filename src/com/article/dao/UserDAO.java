package com.article.dao;

import com.article.connect.JDBCConnect;
import com.article.entity.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {

	public static int register(User u) {
		int status = 0;
		String SQLQuery="insert into user (username,name,email,password,about,isAdmin) values(?,?,?,?,?,?)";
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement(SQLQuery);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getName());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getAbout());
			ps.setBoolean(6, u.getIsAdmin());

			status = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
		}

		return status;
	}

	public static User validate(User user) {
		User userFromDb = null;
		String SQLQuery="select * from user where username=? and password=?";
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(SQLQuery);
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				userFromDb=new User();
				userFromDb.setId(rs.getInt(1));
				userFromDb.setUsername(rs.getString(2));
				userFromDb.setName(rs.getString(3));
				userFromDb.setEmail(rs.getString(4));
				userFromDb.setPassword(rs.getString(5));
				userFromDb.setAbout(rs.getString(6));
				userFromDb.setIsAdmin(rs.getBoolean(7));
				
			}
			rs.close();
			con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	//return (username ==usernameDB && password == passwordDB) ? userFromDb : null;
		return userFromDb;
	}

	public static int update(User u) {
		int status = 0;
		String SQLQuery="update  user set name=?,email=?,about=? where id=?";
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement(SQLQuery);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getAbout());
			ps.setInt(4, u.getId());
			
			status = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
		}

		return status;
	}
	
	public static int Delete(String id[]) {
		String SQLQuery="delete from user where id=?";
		String DeleteForeignKeys="Delete from author_article_category where user_id=?";
		int status = 0;
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(SQLQuery);
			PreparedStatement ps1 = con.prepareStatement(DeleteForeignKeys);
			for(int i=0;i<id.length;i++){
			ps.setInt(1, Integer.parseInt(id[i]));
			ps1.setInt(1, Integer.parseInt(id[i]));
			status = ps.executeUpdate();
			status=ps1.executeUpdate();
			}
			con.close();
		} catch (SQLException e) {
		}

		return status;
	}

	public static ArrayList<User> displayAll() {
		String SQLQuery="select * from user order by name";
		ArrayList<User> ls = new ArrayList<User>();
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement(SQLQuery);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ls.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getBoolean(7)));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
		}
		return ls;
	}
}
// ls returns the list of objects of this class.


