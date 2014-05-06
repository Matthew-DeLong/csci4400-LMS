package com.lms.entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

import com.lms.databaseinterfaces.ItemDatabaseInterface;
import com.lms.demo.DemoItemDatabase;

public class Item {

	String name;
	String category;
	float dailyLateFee;
	float maxLateFee;
	int copies;
	LinkedList<Copy> copiesOut;
	LinkedList<String> reservationList;
	static ItemDatabaseInterface database;
	
	
	public Item(String name, String category, float dailyLateFee, float maxLateFee, int copies){
		this.name = name;
		this.category = category;
		this.dailyLateFee = dailyLateFee;
		this.maxLateFee = maxLateFee;
		this.copies = copies;
		copiesOut = new LinkedList<Copy>();
		reservationList = new LinkedList<String>();
	}
	
	public boolean hasOverdueCopies(){
		boolean overdueCopyFound = false;
		for(Copy copy : copiesOut){
			if(copy.isOverdue()){
				overdueCopyFound = true;
			}
		}
		return overdueCopyFound;
	}
	
	public LinkedList<Copy> getOverdueCopies(){
		LinkedList<Copy> overdueCopies = new LinkedList<Copy>();
		for(Copy copy : copiesOut){
			if(copy.isOverdue()){
				overdueCopies.add(copy);
			}
		}
		return overdueCopies;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getDailyLateFee() {
		return dailyLateFee;
	}

	public void setDailyLateFee(float dailyLateFee) {
		this.dailyLateFee = dailyLateFee;
	}

	public float getMaxLateFee() {
		return maxLateFee;
	}

	public void setMaxLateFee(float maxLateFee) {
		this.maxLateFee = maxLateFee;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}
	
	public LinkedList<String> getReservationList() {
		return reservationList;
	}

	public void setReservationList(LinkedList<String> reservationList) {
		this.reservationList = reservationList;
	}

	public int copiesAvaliable(){
		return copies - copiesOut.size();
	}

	//Used when an Item's information is updated
	public void transferCopiesAndReservationsTo(Item updatedItem){
		updatedItem.setSetCopiesOut(copiesOut);
		updatedItem.setReservationList(reservationList);
	}

	public boolean reservationsExist(){
		return !reservationList.isEmpty();
	}
	
	public void addReservation(String reserver){
		reservationList.add(reserver);
	}
	
	public void removeReservation(String reserver) {
		reservationList.remove(reserver);
		
	}

	protected void setSetCopiesOut(LinkedList<Copy> copiesOut) {
		this.copiesOut = copiesOut;
		
	}
	
	public Copy checkOutCopy(String memberName){
		Copy copy = new Copy(this, memberName);
		copiesOut.add(copy);
		return copy;
	}
	
	public void returnCopy(Copy copy){
		copiesOut.remove(copy);
	}
	
	
	//Testing methods
	
	public void addOverdueCopy(int daysOverdue){
		Copy copy = new Copy(this, "Dummy");
		copy.makeOverdue(daysOverdue);
		copiesOut.add(copy);
	}


	//Static
	static{
		database = new DemoItemDatabase();
	}
	
	public static Item getItem(String name, String category){
		return database.getItem(name, category); 
	}
	
	public static void addItem(String name, String category, float dailyLateFee, float maxLateFee, int copies){
		database.addItem(name, category, dailyLateFee, maxLateFee, copies);
	}
	
	public static void addItem(Item item){
		database.addItem(item);
	}
	
	public static boolean itemExists(String name, String category){
		return database.itemExists(name, category);
	}
	
	public static LinkedList<Item> searchForItems(String[] params){
		return database.getItems(params);		
	}
	
	public static void removeItem(String name, String category){
		database.removeItem(name, category);
	}
	

	
	
	//Define Copy. Used to keep track of copies that are checked out;
	public class Copy{
		String member;
		LocalDate outDate, dueDate;
		Item item;
		
		public Copy(Item item, String member){
			this.member = member;
			outDate = LocalDate.now();
			dueDate = outDate.plusDays(7);
			this.item = item;
		}
		
		public String getBorrower(){
			return member;
		}
		
		public boolean isOverdue(){
			return dueDate.isBefore(LocalDate.now());
		}
		
		public int getDaysLate(){
			return (int) ChronoUnit.DAYS.between(dueDate, LocalDate.now());
		}
		
		//testing methods
		public void makeOverdue(int daysOverdue){
			dueDate = LocalDate.now().minusDays(daysOverdue);
		}

		public Item getItem() {
			return item;
		}
		
		public float getFees(){
			float fees = this.getDaysLate() *  item.getDailyLateFee();
			return Math.min(item.getMaxLateFee(), fees);
			
		}
		
		public LocalDate getDueDate(){
			return dueDate;
		}
		
	}




	
	
}
