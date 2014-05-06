package com.lms.entity;

import java.util.LinkedList;

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
	
	public static void addAccount(String name, String password){
		database.addAccount(name, password);
	}

	public static LinkedList<LibrarianAccount> addAllAccounts(){
		return database.getAllAccounts();
	}
	
	public static void removeAccount(String name){
		database.removeAccount(name);
	}
	
	public static Boolean accountExists(String name){
		return database.accountExists(name);
	}
}
