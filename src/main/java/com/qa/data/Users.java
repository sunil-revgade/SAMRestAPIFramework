package com.qa.data;

public class Users {
	
	String user;
	String job;
	String id;
	String createdAt;
	String updatedAt;
	
	
	public Users()
	{
		
	}
	
	public Users(String name, String job)
	{
		this.user = name;
		this.job = job;
		
	}

//Getter and Setter methods
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	
	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	
	
}
