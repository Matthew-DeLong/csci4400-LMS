package com.lms.entity;

import com.lms.databaseinterfaces.AdminDatabaseInterface;
import com.lms.demo.DemoAdminDatabase;

public class AdminAccount extends Account{
	
	public static AdminDatabaseInterface database;
	
	//Object Functions
	public AdminAccount(String name, String password) {
		super(name, password, "Administrator");
		// TODO Auto-generated constructor stub
	}
	
	
	
	//Static Functions
	 //Initializer
	static{
		database = new DemoAdminDatabase();
	}
	
	public static AdminAccount getAccount(String name, String password){
		return database.getAccount(name, password);
	}

}
