package com.article.entity;

import java.util.Date;

public class Article {

	private String name;
	private int id;
	
	private String content;
	private Date date;
	private String author_name;

	

	public Article() {
	}

	public Article( int id,String name,String author_name, String content) {
		this.name = name;
		this.content = content;
		this.author_name= author_name;
		this.id = id;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
}
