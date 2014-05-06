package com.lms.control;

import java.util.LinkedList;

import com.lms.boundary.abstractions.Messagable;
import com.lms.entity.LibrarianAccount;
import com.lms.entity.MemberAccount;

public class AdminActionsControl {

	public static String[][] getLibrarians() {
		LinkedList<LibrarianAccount> accts = LibrarianAccount.addAllAccounts();
		String[][] list = new String[accts.size()][1];
		int counter = 0;
		for(LibrarianAccount acct : accts){
			list[counter][0] = acct.getName();
			counter++;
		}
			
		return list;
	}

	public static String[][] getVisitors() {
		LinkedList<MemberAccount> accts = MemberAccount.addAllAccounts();
		String[][] list = new String[accts.size()][2];
		int counter = 0;
		for(MemberAccount acct : accts){
			list[counter][0] = acct.getName();
			list[counter][1] = acct.getAddress();
			counter++;
		}			
		return list;
	}
	
	public static void addLibrarian(Messagable ui, String name, String password) {
		if(LibrarianAccount.accountExists(name)){
			ui.sendMessage("ERROR: Account already exists");
		}else{
			LibrarianAccount.addAccount(name, password);
			ui.sendMessage("SUCCESS: Account created.");
		}
	}
	
	public static void removeLibrarian(Messagable ui, String name) {
		if(!LibrarianAccount.accountExists(name)){
			ui.sendMessage("ERROR: Account doesn't exist");
		}else{
			LibrarianAccount.removeAccount(name);;
			ui.sendMessage("SUCCESS: Account removed.");
		}
	}
	
	public static void removeMember(Messagable ui, String name) {
		if(!MemberAccount.accountExists(name)){
			ui.sendMessage("ERROR: Account doesn't exist");
		}else{
			MemberAccount.removeAccount(name);
			ui.sendMessage("SUCCESS: Account removed.");
		}
	}

}
