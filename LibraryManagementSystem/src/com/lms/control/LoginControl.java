package com.lms.control;


import com.lms.LMS;
import com.lms.boundary.abstractions.LoginBoundaryAbstraction;
import com.lms.databaseinterfaces.DatabaseInterface;
import com.lms.demo.DemoAccountDatabase;
import com.lms.entity.Account;
import com.lms.entity.AdminAccount;
import com.lms.entity.LibrarianAccount;
import com.lms.entity.MemberAccount;

public class LoginControl {
	
	LoginBoundaryAbstraction boundary;
	DatabaseInterface accountDatabase;
	
	public LoginControl(LoginBoundaryAbstraction lba){
		boundary=lba;
		accountDatabase = new DemoAccountDatabase();
		
	}
	
	
	public void login(String username, String password, String type){
		switch(type){
			case "Member":
				MemberAccount mAcct = MemberAccount.getAccount(username, password);
				if(mAcct != null){
					boundary.openMemeberHomepage(mAcct);
				}else{
					boundary.displayLoginError();
				}
				break;
			case "Librarian":
				LibrarianAccount lAcct = LibrarianAccount.getAccount(username, password);
				if(lAcct != null){
					boundary.openLibrarainHomepage(lAcct);
				}else{
					boundary.displayLoginError();
				}
				break;
			case "Administrator":
				AdminAccount aAcct = AdminAccount.getAccount(username, password);
				if(aAcct != null){
					boundary.openAdminHomepage(aAcct);
				}else{
					boundary.displayLoginError();
				}
				break;
			case "Anonymous":
				boundary.openAnonymousHomepage();
				break;
		}
		
	}
	

}
