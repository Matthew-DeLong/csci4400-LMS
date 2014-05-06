package com.lms.entity;

import java.util.LinkedList;

import com.lms.databaseinterfaces.BookDatabaseInterface;
import com.lms.demo.DemoBookDatabase;


public class Book extends Item{

	String title, author;
	static BookDatabaseInterface database;
	
	public Book(String isbn, String category, String title, String author,  float dailyLateFee, float maxLateFee, int copies) {
		super(isbn, category, dailyLateFee, maxLateFee, copies);
		this.author = author;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}











	static{
		database = new DemoBookDatabase();
	}
	
	public static Book getBook(String isbn){
		return database.getBook(isbn); 
	}
	
	public static void addBook(String isbn, String category, String title, String author, float dailyLateFee, float maxLateFee, int copies){
		database.addBook(isbn, category, title, author, dailyLateFee, maxLateFee, copies);
	}
	
	public static void addBook(Book Book){
		database.addBook(Book);
	}
	
	public static boolean bookExists(String isbn){
		return database.bookExists(isbn);
	}
	
	public static LinkedList<Book> searchForBooks(String[] params){
		return database.getBooks(params);		
	}
	
	public static void removeBook(String isbn){
		database.removeBook(isbn);
	}
	
}
