package com.article.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.article.connect.JDBCConnect;
import com.article.entity.*;

public class ArticleDao {

	public static int add(Article a, String[] categ) {
		int status = 0;
		String AddArticle = "insert into article values(?,?,?,?,?)";
		try {
			Connection con = JDBCConnect.getConnection();

			PreparedStatement ps = con.prepareStatement(AddArticle);
			ps.setString(1, a.getName());
			ps.setString(2, a.getId());
			ps.setString(3, a.getAuthorId());
			ps.setString(4, a.getContent());
			ps.setDate(5, (Date) a.getDate());
			status = ps.executeUpdate();
			for (int i = 0; i < categ.length; i++) {
				connectToCategory(a, categ, i);
				connectToAuthor(a, categ, i);
			}
		} catch (Exception e) {
		}

		return status;
	}

	public static int Delete(Article a) {
		int status = 0;
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement("Delete from article where name = '"
							+ a.getName() + "'");

			status = ps.executeUpdate();
		} catch (Exception e) {
		}

		return status;
	}

	public static int connectToCategory(Article a, String[] categ, int i)
			throws SQLException {
		String AddArticle_Cat = "insert into article_cat values(?,?)";

		Connection con = JDBCConnect.getConnection();
		PreparedStatement ps1 = con.prepareStatement(AddArticle_Cat);
		ps1.setString(1, a.getId());
		ps1.setString(2, categ[i]);
		int s = ps1.executeUpdate();
		return s;
	}

	public static int connectToAuthor(Article a, String[] categ, int i)
			throws SQLException {
		String AddArticle_Cat = "insert into author_cat values(?,?)";

		Connection con = JDBCConnect.getConnection();
		PreparedStatement ps1 = con.prepareStatement(AddArticle_Cat);
		ps1.setString(1, a.getAuthorId());
		ps1.setString(2, categ[i]);
		int s = ps1.executeUpdate();
		return s;
	}

	public static ArrayList<Article> display() {
		ArrayList<Article> ls = new ArrayList<Article>();
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select id,name,content from article order by Date DESC");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ls.add(new Article(rs.getString(1), rs.getString(2), rs
						.getString(3)));
			}
		} catch (Exception e) {
		}
		return ls;
	}

	
	
	public static ArrayList<Article> display(User user) {
		ArrayList<Article> ls = new ArrayList<Article>();
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select id,name,content from article where author_id = '"+user.getId()+"'");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ls.add(new Article(rs.getString(1), rs.getString(2), rs
						.getString(3)));
			}
		} catch (Exception e) {
		}
		return ls;
	}

	
	public static Article validate(String art) {
		Article ArticleFromDb = new Article();
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from Article where id=?");

			ps.setString(1, art);
			ResultSet rs = ps.executeQuery();
			// status = rs.next();
			if (rs.next()) {
				ArticleFromDb.setName(rs.getString(1));
				ArticleFromDb.setId(rs.getString(2));
				ArticleFromDb.setAuthorId(rs.getString(3));
				ArticleFromDb.setContent(rs.getString(4));
				ArticleFromDb.setDate(rs.getDate(5));
			}

		} catch (Exception e) {
		}

		return ArticleFromDb;

	}
	
}
