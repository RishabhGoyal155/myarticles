package com.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.article.connect.JDBCConnect;
import com.article.entity.*;

public class CategoryDao {

	public static int add(Category category) {
		String SQLQuery="insert into category(name) values(?)";
		int status = 0;
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement(SQLQuery);
			ps.setString(1, category.getName());
			status = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
		}

		return status;

	}

	public static int delete(Category category) {
		int status = 0;
		String SQLQuery="delete from category where id=?";
		String DeleteForeignKeys="Delete from author_article_category where category_id=?";
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(SQLQuery);
			PreparedStatement ps1 = con.prepareStatement(DeleteForeignKeys);
			ps.setInt(1, category.getId());
			ps1.setInt(1, category.getId());
			status = ps.executeUpdate();
			status=ps1.executeUpdate();
			con.close();
		} catch (SQLException e) {
		}

		return status;

	}
	
/**\
 * It is used to display the list of categories on index page
 * @return
 */
	public static ArrayList<Category> display() {
		String SQLQuery="select * from category order by name";
		ArrayList<Category> categoryList = new ArrayList<Category>();
		try {
			
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(SQLQuery);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				categoryList.add(new Category(rs.getInt(1), rs.getString(2)));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
		}
		return categoryList;
	}

	/**
	 * it fetches articles that belongs to a particular category
	 * @param cat_id
	 * @return
	 */
	public static ArrayList<Article> fetch(String cat_id) {
		
		ArrayList<Article> articleList =new ArrayList<Article>();
		
	/*	ArrayList<Integer> articleIdList =new ArrayList<Integer>();
	String SQLQUERY="select article_id from author_article_category where category_id =?";
	String fetchArticleQuery="select id,name,author_name,content from article where id=?";
		try {Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(SQLQUERY);
			ps.setString(1, cat_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {articleIdList.add(rs.getInt(1));}
			rs.close();
			con.close();
		} catch (SQLException e) {}
		if(articleIdList.size()!=0){
			try {
				Connection con = JDBCConnect.getConnection();
				ResultSet rs=null;
				PreparedStatement ps = con.prepareStatement(fetchArticleQuery);
				for(int i=0;i<articleIdList.size();i++){
				ps.setInt(1, articleList.get(i).getId());
				rs = ps.executeQuery();
				while (rs.next()) {articleList.add(new Article(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));}}
				rs.close();
				con.close();
			} catch (SQLException e) {
			}
			SELECT sum(price) FROM table2 INNER JOIN table1 ON table2.id = table1.theid WHERE table1.user_id = 'my_id'
		}    */
		
		//String SQLQUERY="select id,name,author_name,content from article INNER JOIN author_article_category.article_id=article.id where author_article_category.category_id=?";
		String SQLQuery="select * from article a inner join author_article_category cl  on a.id = cl.article_id where cl.category_id =?";
		try {
			Connection con = JDBCConnect.getConnection();
			ResultSet rs=null;
			PreparedStatement ps = con.prepareStatement(SQLQuery);
			ps.setString(1, cat_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				articleList.add(new Article(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
				}
			
			rs.close();
			con.close();
		} catch (SQLException e) {
		}
		
		return articleList;
		
	}
	
}