package com.lms.entity;

import com.lms.databaseinterfaces.LibrarianDatabaseInterface;
import com.lms.demo.DemoLibrarianDatabase;

public class LibrarianAccount extends Account{

	static LibrarianDatabaseInterface database;
	
	//Object Functions
	public LibrarianAccount(String name, String password) {
		super(name, password, "Librarian");
		// TODO Auto-generated constructor stub
	}
	
	
	
	//Static Functions
	 //Initializer
	static{
		database = new DemoLibrarianDatabase();
	}
	
	public static LibrarianAccount getAccount(String name, String password){
		return database.getAccount(name, password);
	}

}
