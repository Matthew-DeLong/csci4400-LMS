package com.lms.entity;

import com.lms.databaseinterfaces.MemberDatabaseInterface;
import com.lms.demo.DemoMemberDatabase;

public class MemberAccount extends Account{
	static MemberDatabaseInterface database;

	//Object Functions
	public MemberAccount(String name, String password) {
		super(name, password, "Member");
		
	}
	

	
	
	
	//Static functions
	 //Initializer
	static{
		database = new DemoMemberDatabase();
	}
	
	public static MemberAccount getAccount(String accountName, String pass){
		return database.getAccount(accountName, pass);
	}

	
}
