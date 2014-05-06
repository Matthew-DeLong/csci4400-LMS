package com.lms.demo;

import java.util.LinkedList;

import com.lms.databaseinterfaces.LibrarianDatabaseInterface;
import com.lms.entity.LibrarianAccount;
import com.lms.entity.MemberAccount;

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

	@Override
	public LibrarianAccount getAccount(String name) {
		for(LibrarianAccount acct: demoDatabase){
			if(acct.getName().equals(name)){
				return acct;
			}
		}
		return null;
	}

	@Override
	public void addAccount(String name, String pass) {
		demoDatabase.add(new LibrarianAccount(name, pass));
	}

	@Override
	public void removeAccount(String name) {
		for(LibrarianAccount acct: demoDatabase){
			if(acct.getName().equals(name)){
				demoDatabase.remove(acct);
			}
		}	
	}

	@Override
	public LinkedList<LibrarianAccount> getAllAccounts() {
		return demoDatabase;
	}

	@Override
	public Boolean accountExists(String name) {
		boolean accountFound = false;
		for(LibrarianAccount acct: demoDatabase){
			if(acct.getName().equals(name)){
				accountFound = true;
			}
		}
		return accountFound;
	}

}
