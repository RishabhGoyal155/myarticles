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

	public static int add(Article a, String[] categ,User user) {
		int status = 0;
		String AddArticle = "insert into article(name,author_name,content,date) values(?,?,?,?)";
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(AddArticle);
				ps.setString(1, a.getName());
			    ps.setString(2, a.getAuthor_name());
			    ps.setString(3, a.getContent());
			    ps.setDate(4, (Date) a.getDate());
			status = ps.executeUpdate();
			if(status!=0){
				addForeignKeys(categ,user);
				}
			con.close();
			} 
			catch (SQLException e) {e.printStackTrace();
			}
			
          return status;
	}

	
	
	public static int Delete(String id[]) {
		int status = 0;
		String DeleteQuery="Delete from article where id =?";
		String DeleteForeignKeys="Delete from author_article_category where article_id=?";
		try {	
		Connection con = JDBCConnect.getConnection();
			PreparedStatement ps1,ps2;
			for(int i=0;i<id.length;i++){
				ps1 = con.prepareStatement(DeleteQuery);
				ps2 = con.prepareStatement(DeleteForeignKeys);
			    ps1.setInt(1,Integer.parseInt(id[i]));
			    ps2.setInt(1,Integer.parseInt(id[i]));
                status = ps1.executeUpdate();
				status = ps2.executeUpdate();
			}
			con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return status;
	}
/**\
 * need to be updated
 * @param id
 * @return
 */
	public static int update(Article article) {
		int status = 0;
		String DeleteQuery="update article set name=?, content=?,date=? where id =?";
		try {	
		Connection con = JDBCConnect.getConnection();
			PreparedStatement ps1;
				ps1 = con.prepareStatement(DeleteQuery);
				ps1.setString(1, article.getName());
				ps1.setString(2,article.getContent());
				ps1.setDate(3, (Date) article.getDate());
				ps1.setInt(4, article.getId());
			    status = ps1.executeUpdate();
			con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return status;
	}

	
	private static void addForeignKeys(String[] categ,User user)
	{
		int articleId=0;
		int userId=user.getId();
		int categoryId=0;
		String SQLQuery="select id from article order by Date DESC limit 1";
		try{
			 Connection con = JDBCConnect.getConnection();
			 PreparedStatement ps1 = con.prepareStatement(SQLQuery);
				ResultSet rs = ps1.executeQuery();
			   if(rs.next()) {
			    articleId=rs.getInt(1);
			    con.close();
			   }
		
		String CategoryQuery="select id from category where name=?";
			 
			 Connection con1 = JDBCConnect.getConnection();
			 
			 for(int i=0;i<categ.length;i++){
			  PreparedStatement ps2=con1.prepareStatement(CategoryQuery);
			  ps2.setString(1, categ[i]);
			  ResultSet rs1 = ps2.executeQuery();
			   if(rs1.next()){
				  categoryId=rs1.getInt(1) ;
			   }
		   setForeignKeys(articleId, userId, categoryId);
		    }//for loop ends
			con1.close();
		}
		catch (SQLException e) {}

	}
	
	private static int setForeignKeys(int articleId, int userId, int categoryId)
			 {
		int s=0;
		String setforeignkeys = "insert into author_article_category values(?,?,?)";
		try {
			Connection con2 = JDBCConnect.getConnection();
		PreparedStatement ps3 = con2.prepareStatement(setforeignkeys);
		ps3.setInt(1, userId);
		ps3.setInt(2, articleId);
		ps3.setInt(3, categoryId);
		 s = ps3.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	public static ArrayList<Article> displayAll() {
		String SQLQuery="select id,name,author_name,content from article order by Date DESC";
		ArrayList<Article> articleList = new ArrayList<Article>();
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(SQLQuery);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				articleList.add(new Article(rs.getInt(1), rs.getString(2), rs
						.getString(3),rs.getString(4)));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
		}
		return articleList;
	}

	public static ArrayList<Article> displayToUser(User user) {
		ArrayList<Article> articleList = new ArrayList<Article>();
		String SQLQuery="select id,name,author_name,content from article where author_name=?";
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(SQLQuery);
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				articleList.add(new Article(rs.getInt(1), rs.getString(2), rs
						.getString(3),rs.getString(4)));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
		}
		return articleList;
	}
	
	
	public static ArrayList<Article> displayInCategory(String category) {
		ArrayList<Article> articleList = new ArrayList<Article>();
		String SQLQuery="select id,name,author_name,content from article where author_name=?";
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(SQLQuery);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				articleList.add(new Article(rs.getInt(1), rs.getString(2), rs
						.getString(3),rs.getString(4)));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
		}
		return articleList;
	}
	
	public static Article validate(String art) {
		Article ArticleFromDb = null;
		String SQLQuery="select * from Article where id=?";
		try {
			Connection con = JDBCConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement(SQLQuery);

			ps.setString(1, art);
			ResultSet rs = ps.executeQuery();
			// status = rs.next();
			if (rs.next()) {
                ArticleFromDb=new Article();
				ArticleFromDb.setId(rs.getInt(1));
				ArticleFromDb.setName(rs.getString(2));
				ArticleFromDb.setAuthor_name(rs.getString(3));
				ArticleFromDb.setContent(rs.getString(4));
				ArticleFromDb.setDate(rs.getDate(5));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
		}

		return ArticleFromDb;

	}
	
}
