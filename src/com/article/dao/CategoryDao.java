package com.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.article.connect.JDBCConnect;
import com.article.entity.*;

public class CategoryDao {

	public static int add(Category a) {
		int status = 0;
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into category values(?,?)");
			ps.setString(1, a.getId());
			ps.setString(2, a.getName());
			status = ps.executeUpdate();
		} catch (Exception e) {
		}

		return status;

	}

	public static int delete(Category a) {
		int status = 0;
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement("delete from category where name='"
							+ a.getName() + "' or id='" + a.getName() + "'");

			status = ps.executeUpdate();
		} catch (Exception e) {
		}

		return status;

	}

	public static ArrayList<Category> display() {
		ArrayList<Category> ls = new ArrayList<Category>();
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from category order by name");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ls.add(new Category(rs.getString(1), rs.getString(2)));
			}
		} catch (Exception e) {
		}
		return ls;
	}

	
	public static ArrayList<Article> fetch(String cat_id) {
		ArrayList<Article> ls = new ArrayList<Article>();
	String SQLQUERY="select id,name,content from article where id in (select article_id from article_cat where category_id = '"+cat_id+"')";
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(SQLQUERY);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ls.add(new Article(rs.getString(1), rs.getString(2), rs
						.getString(3)));
			}
		} catch (Exception e) {
		}
		return ls;
	}
	
}