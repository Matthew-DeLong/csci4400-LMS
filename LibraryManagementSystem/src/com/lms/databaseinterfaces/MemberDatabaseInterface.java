package com.lms.databaseinterfaces;

import com.lms.entity.MemberAccount;

public interface MemberDatabaseInterface {
	
	public MemberAccount getAccount(String name, String password);
	
	

}
