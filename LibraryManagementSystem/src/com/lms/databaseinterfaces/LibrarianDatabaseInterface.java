package com.lms.databaseinterfaces;

import com.lms.entity.LibrarianAccount;

public interface LibrarianDatabaseInterface {
	
	public LibrarianAccount getAccount(String name, String pass);

}
