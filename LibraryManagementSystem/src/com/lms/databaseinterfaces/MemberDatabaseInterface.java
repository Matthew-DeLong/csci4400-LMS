package com.lms.databaseinterfaces;

import java.util.LinkedList;

import com.lms.entity.MemberAccount;

public interface MemberDatabaseInterface {
	
	public MemberAccount getAccount(String name, String password);
	
	public MemberAccount getAccount(String name);
	
	public void removeAccount(String name);
	
	public void addAccount(String name, String password, String address);
	
	public boolean accountExists(String name);
	
	public LinkedList<MemberAccount> getAllAccounts();

}
