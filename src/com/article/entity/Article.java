package com.article.entity;

import java.util.Date;

public class Article {

	private String name;
	private String id;
	private String content;
	private Date date=new Date();
	private User user=new User();
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
	
	
	public String getauthorId() {
		return user.getId();
	}
	public void setauthorId(User user) {
		this.id = user.getId();
	}
}
