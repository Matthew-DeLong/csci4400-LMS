package com.lms.entity;

import java.util.LinkedList;

import com.lms.databaseinterfaces.MemberDatabaseInterface;
import com.lms.demo.DemoMemberDatabase;
import com.lms.entity.Item.Copy;

public class MemberAccount extends Account{
	
	String address;
	LinkedList<Copy> itemsBorrowed;
	LinkedList<Copy> booksBorrowed;
	LinkedList<Item> reservedItems;
	LinkedList<Book> reservedBooks;
	int feesOwed;
	
	static int maxNumberOfItems = 3;
	static MemberDatabaseInterface database;

	//Object Functions
	public MemberAccount(String name, String password, String address) {
		super(name, password, "Member");
		this.address = address;
		itemsBorrowed = new LinkedList<Copy>();
		booksBorrowed = new LinkedList<Copy>();
		reservedItems = new LinkedList<Item>();
		reservedBooks = new LinkedList<Book>();
		feesOwed = 0;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LinkedList<Copy> getItemsBorrowed() {
		return itemsBorrowed;
	}

	public void setItemsBorrowed(LinkedList<Copy> itemsBorrowed) {
		this.itemsBorrowed = itemsBorrowed;
	}

	public LinkedList<Copy> getBooksBorrowed() {
		return booksBorrowed;
	}

	public void setBooksBorrowed(LinkedList<Copy> booksBorrowed) {
		this.booksBorrowed = booksBorrowed;
	}

	public LinkedList<Item> getReservedItems() {
		return reservedItems;
	}
	
	public LinkedList<Book> getReservedBooks() {
		return reservedBooks;
	}

	public void setReservedBooks(LinkedList<Book> reservedBooks) {
		this.reservedBooks = reservedBooks;
	}

	public void setReservedItems(LinkedList<Item> reservedItems) {
		this.reservedItems = reservedItems;
	}

	public boolean numberOfBorrowedItemsMaxed(){
		if(itemsBorrowed.size()+booksBorrowed.size() >= maxNumberOfItems){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean hasOverdueItems(){
		boolean overdueItemFound = false;
		for(Copy copy : itemsBorrowed){
			if(copy.isOverdue()){
				overdueItemFound = true;
			}
		}
		for(Copy copy : booksBorrowed){
			if(copy.isOverdue()){
				overdueItemFound = true;
			}
		}
		return overdueItemFound;
	}
	
	public boolean owesFees(){
		if(feesOwed>0){
			return true;
		}else{
			return false;
		}
	}

	public boolean hasBorrowedItem(Item item){
		for(Copy borrowed: itemsBorrowed){
			if(borrowed.getItem() == item){
				return true;
			}
		}
		return false;
	}

	public boolean hasBorrowedBook(Book item){
		for(Copy borrowed: booksBorrowed){
			if(borrowed.getItem() == item){
				return true;
			}
		}
		return false;
	}
	
	public void checkOutItem(Item item){
		Copy copy = item.checkOutCopy(getName());
		itemsBorrowed.add(copy);
	}
	
	public void returnItem(Item item) {
		for(Copy borrowed: itemsBorrowed){
			if(borrowed.getItem() == item){
				itemsBorrowed.remove(borrowed);
				borrowed.getItem().returnCopy(borrowed);
			}
		}		
		
	}

	public void checkOutBook(Book item) {
		Copy copy = item.checkOutCopy(getName());
		booksBorrowed.add(copy);
		
	}
	
	public void returnBook(Item item) {
		for(Copy borrowed: booksBorrowed){
			if(borrowed.getItem() == item){
				booksBorrowed.remove(borrowed);
				borrowed.getItem().returnCopy(borrowed);
			}
		}		
		
	}

	//Static functions
	 //Initializer
	static{
		database = new DemoMemberDatabase();
	}
	
	public static MemberAccount getAccount(String accountName, String pass){
		return database.getAccount(accountName, pass);
	}
	
	public static MemberAccount getAccount(String accountName){
		return database.getAccount(accountName);
	}
	
	public static void addAccount(String accountName, String password, String address){
		database.addAccount(accountName, password, address);
	}
	
	public static void removeAccount(String name){
		database.removeAccount(name);
	}
	
	public static Boolean accountExists(String name){
		return database.accountExists(name);
	}

	public static LinkedList<MemberAccount> addAllAccounts() {
		return database.getAllAccounts();
	}




	
}
