package com.lms.databaseinterfaces;

import com.lms.entity.AdminAccount;

public interface AdminDatabaseInterface {
	
	public AdminAccount getAccount(String name, String password);

}
