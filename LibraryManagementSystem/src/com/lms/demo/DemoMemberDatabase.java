package com.lms.demo;

import java.util.LinkedList;

import com.lms.databaseinterfaces.MemberDatabaseInterface;
import com.lms.entity.MemberAccount;

public class DemoMemberDatabase implements MemberDatabaseInterface{

	LinkedList<MemberAccount> demoDatabase;
	
	public DemoMemberDatabase(){
		demoDatabase = new LinkedList<MemberAccount>();
		demoDatabase.add(new MemberAccount("JohnQPublic", "hisbirthday"));
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

}
