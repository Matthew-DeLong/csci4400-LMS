package com.lms.entity;

public class Account {

	String name;
	String password;
	String address;
	String type;
		
	public Account(String name, String password, String type){
		this.name = name;
		this.password = password;
		this.type = type;
	}
	
	public Account(String[] fields){
		name = fields[0];
		password = fields[1];
		type = fields[2];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
