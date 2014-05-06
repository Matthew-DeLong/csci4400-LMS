package com.lms.demo;

import java.util.LinkedList;

import com.lms.databaseinterfaces.MemberDatabaseInterface;
import com.lms.entity.MemberAccount;

public class DemoMemberDatabase implements MemberDatabaseInterface{

	LinkedList<MemberAccount> demoDatabase;
	
	public DemoMemberDatabase(){
		demoDatabase = new LinkedList<MemberAccount>();
		demoDatabase.add(new MemberAccount("JohnQPublic", "hisbirthday", "5213 Road Lane"));
	}

	@Override
	public MemberAccount getAccount(String name, String password) {
		for(MemberAccount acct: demoDatabase){
			String acctName = acct.getName();
			String acctPassword = acct.getPassword();
			if(acctName.equals(name) && acctPassword.equals(password)){
				return acct;
			}
		}
		return null;
	}

	@Override
	public MemberAccount getAccount(String name) {
		for(MemberAccount acct: demoDatabase){
			if(acct.getName().equals(name)){
				return acct;
			}
		}
		return null;
	}

	@Override
	public void removeAccount(String name) {
		for(MemberAccount acct: demoDatabase){
			if(acct.getName().equals(name)){
				demoDatabase.remove(acct);
			}
		}		
	}

	@Override
	public void addAccount(String name, String password, String address) {
		demoDatabase.add(new MemberAccount(name, password, address));
	}

	@Override
	public boolean accountExists(String name) {
		boolean accountFound = false;
		for(MemberAccount acct: demoDatabase){
			if(acct.getName().equals(name)){
				accountFound = true;
			}
		}
		return accountFound;
	}

	@Override
	public LinkedList<MemberAccount> getAllAccounts() {
		return demoDatabase;
	}

}
