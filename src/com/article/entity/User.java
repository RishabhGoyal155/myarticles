package com.article.entity;

//User pojo
public class User {
	private int id;
	private String username;
	private String name;
	private String email;
	private String password;
	private String about;
	private Boolean isAdmin;
public User(){}
public User(int id,String username,String name,String email,String password,String about,Boolean isAdmin){
	this.id=id;
	this.username=username;
	this.name=name;
	this.about=about;
	this.email=email;
	this.password=password;
	this.isAdmin=isAdmin;
}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
