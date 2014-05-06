package com.lms.databaseinterfaces;

import java.util.LinkedList;

import com.lms.entity.LibrarianAccount;

public interface LibrarianDatabaseInterface {
	
	public LibrarianAccount getAccount(String name, String pass);
	
	public LibrarianAccount getAccount(String name);
	
	public void addAccount(String name, String pass);
	
	public void removeAccount(String name);
	
	public LinkedList<LibrarianAccount> getAllAccounts();
	
	public Boolean accountExists(String name);

}
