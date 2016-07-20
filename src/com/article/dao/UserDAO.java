package com.article.dao;

import com.article.connect.JDBCConnect;
import com.article.entity.User;

import java.sql.*;

public class UserDAO {

	public static int register(User u) {
		int status = 0;
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into user values(?,?,?,?,?,?)");
			ps.setString(1, u.getId());
			ps.setString(2, u.getName());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getAbout());
			ps.setBoolean(6, u.getIsAdmin());

			status = ps.executeUpdate();
		} catch (Exception e) {
		}

		return status;
	}

	public static User validate(User user) {
		User userFromDb = new User();
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from user where id=? and password=?");

			ps.setString(1, user.getId());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();
			// status = rs.next();
			if (rs.next()) {
				userFromDb.setId(rs.getString(1));
				userFromDb.setName(rs.getString(2));
				userFromDb.setEmail(rs.getString(3));
				userFromDb.setAbout(rs.getString(4));
				userFromDb.setPassword(rs.getString(5));
				userFromDb.setIsAdmin(rs.getBoolean(6));
			}

		} catch (Exception e) {
		}

		return userFromDb;

	}

	public static int delete(User u) {
		int status = 0;
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement("delete from user where name ='"
							+ u.getName() + "' OR id='" + u.getName() + "'");

			status = ps.executeUpdate();
		} catch (Exception e) {
		}

		return status;
	}

}
