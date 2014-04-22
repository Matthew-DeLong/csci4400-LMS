package com.lms.demo;

import java.util.LinkedList;

import com.lms.databaseinterfaces.LibrarianDatabaseInterface;
import com.lms.entity.LibrarianAccount;

public class DemoLibrarianDatabase implements LibrarianDatabaseInterface{
	
	LinkedList<LibrarianAccount> demoDatabase;
	
	public DemoLibrarianDatabase(){
		demoDatabase = new LinkedList<LibrarianAccount>();
		demoDatabase.add(new LibrarianAccount("JaneDoe","password"));
	}
	
	@Override
	public LibrarianAccount getAccount(String name, String pass) {
		for(LibrarianAccount acct: demoDatabase){
			String acctName = acct.getName();
			String acctPassword = acct.getPassword();
			if(acctName.equals(name) && acctPassword.equals(pass)){
				return acct;
			}
		}
		return null;
	}

}
