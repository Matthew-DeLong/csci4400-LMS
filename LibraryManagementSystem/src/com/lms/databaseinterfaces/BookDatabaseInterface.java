package com.lms.databaseinterfaces;

import java.util.LinkedList;

import com.lms.entity.Book;

public interface BookDatabaseInterface {

	public Book getBook(String isbn);
	
	public void addBook(String isbn, String category, String title, String author,  float dailyLateFee, float maxLateFee, int copies);
	
	public void addBook(Book book);
	
	public boolean bookExists(String isbn);
	
	public LinkedList<Book> getBooks(String[] params);
	
	public void removeBook(String isbn);
}
