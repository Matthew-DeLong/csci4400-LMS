package com.lms.demo;

import java.util.LinkedList;

import com.lms.databaseinterfaces.AdminDatabaseInterface;
import com.lms.entity.AdminAccount;

public class DemoAdminDatabase implements AdminDatabaseInterface{

	LinkedList<AdminAccount> demoDatabase;
	
	public DemoAdminDatabase(){
		demoDatabase = new LinkedList<AdminAccount>();
		demoDatabase.add(new AdminAccount("JohnDoe", "12345"));
	}

	@Override
	public AdminAccount getAccount(String name, String password) {
		for(AdminAccount acct: demoDatabase){
			String acctName = acct.getName();
			String acctPassword = acct.getPassword();
			if(acctName.equals(name) && acctPassword.equals(password)){
				return acct;
			}
		}
		return null;
	}
	
	
}
