package com.lms.boundary.abstractions;


import com.lms.entity.AdminAccount;
import com.lms.entity.LibrarianAccount;
import com.lms.entity.MemberAccount;

public interface LoginBoundaryAbstraction {
	
	public void displayLoginError();

	public void openAdminHomepage(AdminAccount acct);
	
	public void openLibrarainHomepage(LibrarianAccount acct);
	
	public void openMemeberHomepage(MemberAccount acct);
	
	public void openAnonymousHomepage();
}
