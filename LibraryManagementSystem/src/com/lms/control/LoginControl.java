package com.lms.control;

import com.lms.Account;
import com.lms.DatabaseInterface;
import com.lms.LMS;
import com.lms.boundary.abstractions.LoginBoundaryAbstraction;
import com.lms.demo.DemoAccountDatabase;

public class LoginControl {
	
	LoginBoundaryAbstraction boundary;
	DatabaseInterface accountDatabase;
	
	public LoginControl(LoginBoundaryAbstraction lba){
		boundary=lba;
		accountDatabase = new DemoAccountDatabase();
		
	}
	
	
	public void login(String username, String password, String type){
		Account acct = null;
		int accountNumber = accountDatabase.getRecordNumber(username);
		if(accountNumber!=-1){
			acct = new Account(accountDatabase.getRecord(accountNumber));
		}else{
			if(type!="Anonymous"){
			boundary.displayLoginError();
			}
		}
		
		if(type=="Anonymous"){
			boundary.openHomepage("Anonymous", acct);
		}
		
		if(acct!=null && accountMatchesInput(acct, username, password, type)){
			switch(acct.getType()){
				case "Member":
					boundary.openHomepage("Member", acct);
					break;
				case "Librarian":
					boundary.openHomepage("Librarian", acct);
					break;
				case "Administrator":
					boundary.openHomepage("Administrator", acct);
					break;
			}
		}
		
	}
	
	private boolean accountMatchesInput(Account acct, String username, String password, String type){
		if(username.equals(acct.getName()) && password.equals(acct.getPassword()) && type.equals(acct.getType())){
			return true;
		}else{
			boundary.displayLoginError();
			return false;
		}
	}
	


}
