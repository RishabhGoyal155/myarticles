package com.article.entity;

import java.util.Date;

public class Article {

	private String name;
	private String id;
	private String content;
	private Date date;
	private String authorId;

	public Article() {
	}

	public Article(String id, String name, String content) {
		this.name = name;
		this.content = content;
		this.id = id;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
}
