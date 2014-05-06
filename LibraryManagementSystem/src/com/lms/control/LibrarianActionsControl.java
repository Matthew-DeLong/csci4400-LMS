package com.lms.control;

import java.util.LinkedList;

import com.lms.boundary.abstractions.ItemDisplayer;
import com.lms.boundary.abstractions.Messagable;
import com.lms.entity.Book;
import com.lms.entity.Item;
import com.lms.entity.MemberAccount;
import com.lms.entity.Item.Copy;

public class LibrarianActionsControl {

	//Item Methods
	public static void searchForItems(ItemDisplayer ui, String[] params){
		LinkedList<Item> foundItems = Item.searchForItems(params);
		String[][] items = new String[foundItems.size()][4];
		int counter = 0;
		for(Item item : foundItems){
			items[counter][0] = item.getName();
			items[counter][1] = Integer.toString(item.copiesAvaliable());
			items[counter][2] = Integer.toString(item.getCopies());
			items[counter][3] = item.getCategory();
			counter++;
		}
		ui.displayItems(items);
	}
	
	
	public static void addItem(Messagable ui, String name, String category, float dailyLateFee, float maxLateFee, int numberOfCopies){
		boolean itemAdded = true;
		if(Item.itemExists(name, category)){
			itemAdded = false;
			ui.sendMessage("ERROR: Item already exists");
		}
		if(numberOfCopies < 1){
			itemAdded = false;
			ui.sendMessage("ERROR: Must have at least 1 copy.");
		}
		if(name.isEmpty()){
			itemAdded = false;
			ui.sendMessage("ERROR: Enter a name");
		}
		if(dailyLateFee < 0){
			itemAdded = false;
			ui.sendMessage("ERROR: Enter a Daily Late Fee");
		}
		if(maxLateFee < dailyLateFee){
			itemAdded = false;
			ui.sendMessage("ERROR: Max Late Fee must be less than Daily Late Fee");
		}
		if(maxLateFee < 0){
			itemAdded = false;
			ui.sendMessage("ERROR: Enter a Max Late Fee");
		}
		if(itemAdded){
			Item.addItem(name, category, dailyLateFee, maxLateFee, numberOfCopies);
			ui.sendMessage("SUCCESS: Item added to database");
		}
	}


	public static String[] getItemInformation(String name, String category) {
		String[] info = new String[5];
		Item item = Item.getItem(name, category);
		info[0] = item.getName();
		info[1] = item.getCategory();
		info[2] = Float.toString(item.getDailyLateFee());
		info[3] = Float.toString(item.getMaxLateFee());
		info[4] = Integer.toString(item.getCopies());
		return info;
	}
	
	public static void editItem(Messagable ui, String OldName, String OldCategory, String name, String category, float dailyLateFee, float maxLateFee, int numberOfCopies){
		Item item = Item.getItem(OldName, OldCategory);
		boolean editItemSuccess = true;
		//If the number of copies currently loaned out is greater than then new number of copies
		//the edit fails and a message is displayed
		if(item.getCopies()-item.copiesAvaliable() > numberOfCopies){
			editItemSuccess = false;
			ui.sendMessage("ERROR: The Number of copies currently loaned out is greater than the new number of copies");
		}
		//If the item' category is being changed, test to make sure there isn't already an item of
		//the same name in the new category
		if((!name.equals(OldName) || !category.equals(OldCategory)) && Item.itemExists(name, category)){
			editItemSuccess = false;
			ui.sendMessage("ERROR: There is already item with that name in that category");
		}
		//Item field verification copy and pasted from addItem
		if(numberOfCopies < 1){
			editItemSuccess = false;
			ui.sendMessage("ERROR: Must have at least 1 copy.");
		}
		if(name.isEmpty()){
			editItemSuccess = false;
			ui.sendMessage("ERROR: Enter a name");
		}
		if(dailyLateFee < 0){
			editItemSuccess = false;
			ui.sendMessage("ERROR: Enter a Daily Late Fee");
		}
		if(maxLateFee < dailyLateFee){
			editItemSuccess = false;
			ui.sendMessage("ERROR: Max Late Fee must be greater than Daily Late Fee");
		}
		if(maxLateFee < 0){
			editItemSuccess = false;
			ui.sendMessage("ERROR: Enter a Max Late Fee");
		}
		if(editItemSuccess){
			Item.removeItem(OldName,OldCategory);
			Item updatedItem = new Item(name, category, dailyLateFee, maxLateFee, numberOfCopies);
			item.transferCopiesAndReservationsTo(updatedItem);
			Item.addItem(updatedItem);
			ui.sendMessage("SUCCESS: Item edited");
		}
	}
	
	public static void removeItem(Messagable ui, String name, String category){
		boolean itemRemoved = true;
		Item item = Item.getItem(name, category);
		if(item == null){
			itemRemoved = false;
			ui.sendMessage("ERROR: Item doesn't exist!");
		}
		//If all copies aren't avaliable, don't remove the item and send an error message
		if(item.copiesAvaliable()!=item.getCopies()){
			itemRemoved = false;
			ui.sendMessage("ERROR: All copies must be avaliable in order to remove an item!");
		}
		if(itemRemoved){
			Item.removeItem(name, category);
			ui.sendMessage("SUCCESS: Item was removed.");
		}
	}
	
	public static String[][] getItemReservationList(String name, String category){
		Item item = Item.getItem(name, category);
		LinkedList<String> reservations = item.getReservationList();
		String[][] list = new String[reservations.size()][2];
		int counter = 0;
		for(String memberName: reservations){
			list[counter][0] = Integer.toString(counter+1);
			list[counter][1] = reservations.get(counter);
			counter++;
		}
		return list;
	}
	
	public static String[][] getOverdueCopiesofItem(String name, String category){
		Item item = Item.getItem(name, category);
		LinkedList<Copy> overdueCopies = item.getOverdueCopies();
		String [][] list = new String[overdueCopies.size()][3];
		System.out.println(item.getDailyLateFee());
		System.out.println(item.getMaxLateFee());
		int counter = 0;
		for(Copy copy: overdueCopies){
			list[counter][0] = copy.getBorrower();
			list[counter][1] = Integer.toString(copy.getDaysLate());
			list[counter][2] = Float.toString(Math.min(item.getMaxLateFee(), copy.getDaysLate()*item.getDailyLateFee()));
			counter++;
		}
		
		return list;	
	}
	
	public static void checkOutItem(Messagable ui, String name, String category, String username){
		boolean itemCheckedOut = true;
		MemberAccount acct = MemberAccount.getAccount(username);
		Item item = Item.getItem(name, category);
		//Reject if Member Account or Item Doesn't exist
		if(acct == null){
			itemCheckedOut = false;
			ui.sendMessage("ERROR: Member does not exist!");
		}
		if(item == null){
			itemCheckedOut = false;
			ui.sendMessage("ERROR: Item does not exist!");
		}
		if(acct.numberOfBorrowedItemsMaxed()){
			itemCheckedOut = false;
			ui.sendMessage("ERROR: Member can't borrow anymore items!");
		}
		if(acct.hasOverdueItems()){
			itemCheckedOut = false;
			ui.sendMessage("ERROR: Member has overdue items!");
		}
		if(acct.owesFees()){
			itemCheckedOut = false;
			ui.sendMessage("ERROR: Member owes fees!");
		}
		if(item.copiesAvaliable()==0){
			itemCheckedOut = false;
			ui.sendMessage("ERROR: No Copies Avaliable!");
		}
		if(item.getReservationList().size()>=item.copiesAvaliable() &&( item.getReservationList().indexOf(username) != -1 || item.getReservationList().indexOf(username)+1 > item.copiesAvaliable())){
			itemCheckedOut = false;
			ui.sendMessage("ERROR: User is either not on or too far down the waiting list!");
		}
		if(itemCheckedOut){
			acct.checkOutItem(item);
			ui.sendMessage("SUCCESS: Enjoy your thing!");
		}
	}
	
	public static void returnItem(Messagable ui, String name, String category, String username) {
		MemberAccount acct = MemberAccount.getAccount(username);
		Item item = Item.getItem(name, category);
		boolean itemReturned = true;
		//Reject if Member Account or Item Doesn't exist
		if(acct == null){
			itemReturned = false;
			ui.sendMessage("ERROR: Member does not exist!");
		}
		if(item == null){
			itemReturned = false;
			ui.sendMessage("ERROR: Item does not exist!");
		}
		if(!acct.hasBorrowedItem(item)){
			itemReturned = false;
			ui.sendMessage("ERROR: Member hasn't borrowed that item!");
		}
		if(itemReturned){
			acct.returnItem(item);
			ui.sendMessage("SUCCESS: Item Returned!!!");
		}
	}
	
	//Book Methods
	public static void searchForBooks(ItemDisplayer ui, String[] params){
		LinkedList<Book> foundItems = Book.searchForBooks(params);
		System.out.println(foundItems.size());
		String[][] items = new String[foundItems.size()][6];
		int counter = 0;
		for(Book item : foundItems){
			items[counter][0] = item.getName();
			items[counter][1] = item.getTitle();
			items[counter][2] = item.getAuthor();
			items[counter][3] = Integer.toString(item.copiesAvaliable());
			items[counter][4] = Integer.toString(item.getCopies());
			items[counter][5] = item.getCategory();
			counter++;
		}
		ui.displayItems(items);
	}
	
	public static void addBook(Messagable ui, String isbn, String category, String author, String title, float dailyLateFee, float maxLateFee, int numberOfCopies){
		boolean itemAdded = true;
		if(Book.bookExists(isbn)){
			itemAdded = false;
			ui.sendMessage("ERROR: Item already exists");
		}
		if(numberOfCopies < 1){
			itemAdded = false;
			ui.sendMessage("ERROR: Must have at least 1 copy.");
		}
		if(isbn.isEmpty()){
			itemAdded = false;
			ui.sendMessage("ERROR: Enter an isbn");
		}
		if(dailyLateFee < 0){
			itemAdded = false;
			ui.sendMessage("ERROR: Enter a Daily Late Fee");
		}
		if(maxLateFee < dailyLateFee){
			itemAdded = false;
			ui.sendMessage("ERROR: Max Late Fee must be less than Daily Late Fee");
		}
		if(maxLateFee < 0){
			itemAdded = false;
			ui.sendMessage("ERROR: Enter a Max Late Fee");
		}
		if(itemAdded){
			Book.addBook(isbn, category, title, author, dailyLateFee, maxLateFee, numberOfCopies);
			ui.sendMessage("SUCCESS: Book added to database");
		}
	}
	
	public static void editBook(Messagable ui, String oldIsbn, String isbn, String category, String author, String title, float dailyLateFee, float maxLateFee, int numberOfCopies){
		Book book = Book.getBook(oldIsbn);
		boolean editItemSuccess = true;
		//If the number of copies currently loaned out is greater than then new number of copies
		//the edit fails and a message is displayed
		if(book.getCopies()-book.copiesAvaliable() > numberOfCopies){
			editItemSuccess = false;
			ui.sendMessage("ERROR: The Number of copies currently loaned out is greater than the new number of copies");
		}
		//If the item' category is being changed, test to make sure there isn't already an item of
		//the same name in the new category
		if(!isbn.equals(oldIsbn) && Book.bookExists(isbn)){
			editItemSuccess = false;
			ui.sendMessage("ERROR: There is already book with that ISBN in that category");
		}
		//Field Verification from addBook()
		boolean itemAdded = true;
		if(numberOfCopies < 1){
			itemAdded = false;
			ui.sendMessage("ERROR: Must have at least 1 copy.");
		}
		if(isbn.isEmpty()){
			itemAdded = false;
			ui.sendMessage("ERROR: Enter an isbn");
		}
		if(dailyLateFee < 0){
			itemAdded = false;
			ui.sendMessage("ERROR: Enter a Daily Late Fee");
		}
		if(maxLateFee < dailyLateFee){
			itemAdded = false;
			ui.sendMessage("ERROR: Max Late Fee must be less than Daily Late Fee");
		}
		if(maxLateFee < 0){
			itemAdded = false;
			ui.sendMessage("ERROR: Enter a Max Late Fee");
		}
		if(itemAdded){
			Book.removeBook(oldIsbn);
			Book updatedBook = new Book(isbn, category, title, author, dailyLateFee, maxLateFee, numberOfCopies);
			updatedBook.transferCopiesAndReservationsTo(updatedBook);
			Book.addBook(updatedBook);
			ui.sendMessage("SUCCESS: Book edited");
		}
	}
	
	public static String[] getBookInformation(String isbn) {
		String[] info = new String[7];
		Book book = Book.getBook(isbn);
		info[0] = book.getName();
		info[1] = book.getCategory();
		info[2] = Float.toString(book.getDailyLateFee());
		info[3] = Float.toString(book.getMaxLateFee());
		info[4] = Integer.toString(book.getCopies());
		info[5] = book.getTitle();
		info[6] = book.getAuthor();
		return info;
	}
	
	public static void removeBook(Messagable ui, String isbn){
		boolean bookRemoved = true;
		Book book = Book.getBook(isbn);
		if(book == null){
			bookRemoved = false;
			ui.sendMessage("ERROR: Book doesn't exist!");
		}
		//If all copies aren't avaliable, don't remove the book and send an error message
		if(book.copiesAvaliable()!=book.getCopies()){
			bookRemoved = false;
			ui.sendMessage("ERROR: All copies must be avaliable in order to remove a book!");
		}
		if(bookRemoved){
			Book.removeBook(isbn);
			ui.sendMessage("SUCCESS: Book was removed.");
		}
	}


	public static void checkOutBook(Messagable ui, String isbn, String memberName) {
		boolean itemCheckedOut = true;
		MemberAccount acct = MemberAccount.getAccount(memberName);
		Book item = Book.getBook(isbn);
		//Reject if Member Account Doesn't exist
		if(acct == null){
			itemCheckedOut = false;
			ui.sendMessage("ERROR: Member does not exist!");
		}
		if(item == null){
			itemCheckedOut = false;
			ui.sendMessage("ERROR: Item does not exist!");
		}
		//Reject if Member Account Doesn't exist
		if(acct.numberOfBorrowedItemsMaxed()){
			itemCheckedOut = false;
			ui.sendMessage("ERROR: Member can't borrow anymore items!");
		}
		if(acct.hasOverdueItems()){
			itemCheckedOut = false;
			ui.sendMessage("ERROR: Member has overdue items!");
		}
		if(acct.owesFees()){
			itemCheckedOut = false;
			ui.sendMessage("ERROR: Member owes fees!");
		}
		if(item.copiesAvaliable()==0){
			itemCheckedOut = false;
			ui.sendMessage("ERROR: No Copies Avaliable!");
		}
		if(item.getReservationList().size()>=item.copiesAvaliable() &&( item.getReservationList().indexOf(memberName) != -1 || item.getReservationList().indexOf(memberName)+1 > item.copiesAvaliable())){
			itemCheckedOut = false;
			ui.sendMessage("ERROR: User is either not on or too far down the waiting list!");
		}
		if(itemCheckedOut){
			acct.checkOutBook(item);
			ui.sendMessage("SUCCESS: Enjoy your book!");
		}
		
	}

	public static void returnBook(Messagable ui, String name, String username) {
		MemberAccount acct = MemberAccount.getAccount(username);
		Book item = Book.getBook(name);
		boolean itemReturned = true;
		//Reject if Member Account or Item Doesn't exist
		if(acct == null){
			itemReturned = false;
			ui.sendMessage("ERROR: Member does not exist!");
		}
		if(item == null){
			itemReturned = false;
			ui.sendMessage("ERROR: Item does not exist!");
		}
		if(!acct.hasBorrowedBook(item)){
			itemReturned = false;
			ui.sendMessage("ERROR: Member hasn't borrowed that item!");
		}
		if(itemReturned){
			acct.returnBook(item);
			ui.sendMessage("SUCCESS: Item Returned!!");
		}
	}

	
}
