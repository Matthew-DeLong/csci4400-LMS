package com.lms.demo;

import java.util.ArrayList;
import java.util.List;




import com.lms.databaseinterfaces.DatabaseInterface;
import com.lms.entity.Account;

public class DemoAccountDatabase implements DatabaseInterface{
	//This class simulates a database and will be used for the demo only.
	List<Account> accounts;
	
	
	public DemoAccountDatabase(){
		//Fill the accounts list with demo accounts
		accounts = new ArrayList<Account>();
		accounts.add(new Account("JohnDoe", "12345","Administrator"));
		accounts.add(new Account("JaneDoe", "password","Librarian"));
		accounts.add(new Account("JohnQPublic", "hisbirthday","Member"));
	}


	@Override
	public int getRecordNumber(String name) {
		//Tries to find a record in the accounts list with a matching name.
		// If a matching record is found, it returns its position in the list. Otherwise, -1 is returned
		int recordNumber = -1;
		for(Account acct: accounts){
			if(name.equals(acct.getName())){
				recordNumber = accounts.indexOf(acct);
				return recordNumber;
			}
		}
		return recordNumber;
	}


	@Override
	public String[] getRecord(int recordNumber) {
		String[] record = new String[3];
		Account account = accounts.get(recordNumber);
		record[0] = account.getName();
		record[1] = account.getPassword();
		record[2] = account.getType();
		return record;
	}


	@Override
	public void save(String[] record) {
		// TODO Auto-generated method stub
		
	}

	
	
}
