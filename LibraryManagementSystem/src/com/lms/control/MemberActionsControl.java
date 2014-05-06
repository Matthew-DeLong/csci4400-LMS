package com.lms.control;

import java.util.LinkedList;

import com.lms.boundary.abstractions.ItemDisplayer;
import com.lms.boundary.abstractions.Messagable;
import com.lms.entity.Book;
import com.lms.entity.Item;
import com.lms.entity.Item.Copy;
import com.lms.entity.MemberAccount;

public class MemberActionsControl {
	
	public static void addAccount(Messagable ui,String name, String password, String address){
		boolean accountCreated = true;
		if(name.isEmpty()){
			accountCreated = false;
			ui.sendMessage("ERROR: Enter a name.");
		}
		if(password.isEmpty()){
			accountCreated = false;
			ui.sendMessage("ERROR: Enter a password.");
		}
		if(address.isEmpty()){
			accountCreated = false;
			ui.sendMessage("ERROR: Enter a address.");
		}
		if(MemberAccount.accountExists(name)){
			accountCreated = false;
			ui.sendMessage("ERROR: The name you picked is already taken. Try again.");
			
		}
		if(accountCreated){
			ui.sendMessage("SUCCESS: Please log out and log into your new account!");
			MemberAccount.addAccount(name, password, address);
		}		
	}

	public static void reserveItem(Messagable ui, String memberName, String name, String category) {
		MemberAccount acct = MemberAccount.getAccount(memberName);
		Item item = Item.getItem(name, category);
		acct.getReservedItems().add(item);
		item.addReservation(memberName);
		ui.sendMessage("SUCCESS: Reservation added!");
	}
	
	public static void reserveBook(Messagable ui, String memberName, String isbn) {
		MemberAccount acct = MemberAccount.getAccount(memberName);
		Book item = Book.getBook(isbn);
		acct.getReservedBooks().add(item);
		item.addReservation(memberName);
		ui.sendMessage("SUCCESS: Reservation added!");
	}

	public static String[][] getBorrowedItems(ItemDisplayer ui, String name) {
		LinkedList<Copy> borrowedItems = MemberAccount.getAccount(name).getItemsBorrowed();
		String[][] list = new String[borrowedItems.size()][3];
		int counter = 0;
		for(Copy copy : borrowedItems){
			list[counter][0] = copy.getItem().getName();
			list[counter][1] = copy.getItem().getCategory();
			list[counter][2] = copy.getDueDate().toString();
			counter++;
		}
		return list;
		
	}

	public static String[][] getBorrowedBooks(ItemDisplayer ui, String name) {
		LinkedList<Copy> borrowedItems = MemberAccount.getAccount(name).getBooksBorrowed();
		String[][] list = new String[borrowedItems.size()][3];
		int counter = 0;
		for(Copy copy : borrowedItems){
			list[counter][0] = copy.getItem().getName();
			list[counter][1] = copy.getItem().getCategory();
			list[counter][2] = copy.getDueDate().toString();
			counter++;
		}
		System.out.println(list.length);
		return list;
	}
	
	public static void getReservedBooks(ItemDisplayer ui, String username){
		MemberAccount acct = MemberAccount.getAccount(username);
		LinkedList<Book> reservedList = acct.getReservedBooks();
		String[][] list = new String[reservedList.size()][2];
		int counter = 0;
		for(Book book : reservedList){
			list[counter][0] = book.getTitle();
			list[counter][1] = book.getCategory();
			counter++;
		}
		System.out.println(list.length);
		ui.displayItems(list);
	}
	
	public static void getReservedItems(ItemDisplayer ui, String username){
		MemberAccount acct = MemberAccount.getAccount(username);
		LinkedList<Item> reservedList = acct.getReservedItems();
		String[][] list = new String[reservedList.size()][2];
		int counter = 0;
		for(Item book : reservedList){
			list[counter][0] = book.getName();
			list[counter][1] = book.getCategory();
			counter++;
		}
		System.out.println(list.length);
		ui.displayItems(list);
	}
	
	public static void unreserveItem(String name, String category, String username){
		MemberAccount acct = MemberAccount.getAccount(username);
		LinkedList<Item> reservedList = acct.getReservedItems();
		System.out.println(name+"hello");
		System.out.println(category);
		for(Item book : reservedList){
			if(book.getName().equals(name)&&book.getCategory().equals(category)){
				acct.getReservedItems().remove(book);
				book.removeReservation(username);
			}
		}
		
	}
	
	public static void unreserveBook(String isbn, String username){
		MemberAccount acct = MemberAccount.getAccount(username);
		LinkedList<Book> reservedList = acct.getReservedBooks();
		for(Book book : reservedList){
			if(book.getTitle().equals(isbn)){
				acct.getReservedBooks().remove(book);
				book.removeReservation(username);
			}
		}
	}

}
