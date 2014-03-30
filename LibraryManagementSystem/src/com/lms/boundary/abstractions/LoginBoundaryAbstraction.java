package com.lms.boundary.abstractions;

import com.lms.Account;

public interface LoginBoundaryAbstraction {
	
	public void displayLoginError();

	public void openHomepage(String string, Account acct);


}
