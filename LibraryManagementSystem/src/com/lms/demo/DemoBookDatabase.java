package com.lms.demo;

import java.util.LinkedList;

import com.lms.databaseinterfaces.BookDatabaseInterface;
import com.lms.entity.Book;
import com.lms.entity.Item;

public class DemoBookDatabase implements BookDatabaseInterface{
	
	LinkedList<Book> books;
	
	public DemoBookDatabase(){
		books = new LinkedList<Book>();
		books.add(new Book("12345", "A -- GENERAL WORKS", "Cranberries of Vengence", "Bob Dole", 1.5f, 10, 3));
		books.add(new Book("6789", "T -- TECHNOLOGY", "How to Fight a Velociraptor", "Bob Dole", 1.5f, 10, 3));
		books.add(new Book("5555", "H -- SOCIAL SCIENCES", "Life on the Street", "Elmo", 2, 10, 3));
		books.add(new Book("99894", "T -- TECHNOLOGY", "Rarararrrrrah", "Chewbacca", 1.5f, 10, 2));
		books.add(new Book("4681588", "N -- FINE ARTS", "Hodor", "Hodor", 100, 1000, 1));
	}

	@Override
	public Book getBook(String isbn) {
		for(Book book : books){
			if(book.getName().equals(isbn)){
				return book;
			}
		}
		return null;
	}

	@Override
	public void addBook(String isbn, String category, String title,
			String author, float dailyLateFee, float maxLateFee, int copies) {
		books.add(new Book(isbn, category, author, title, dailyLateFee, maxLateFee, copies));
		
	}

	@Override
	public void addBook(Book book) {
		books.add(book);
		
	}

	@Override
	public boolean bookExists(String isbn) {
		boolean bookFound = false;
		for(Book book : books){
			if(book.getName().equals(isbn)){
				bookFound = true;
			}
		}
		return bookFound;
	}

	@Override
	public LinkedList<Book> getBooks(String[] params) {
		LinkedList<Book> foundBooks = new LinkedList<Book>();
		for(Book book : books){			
			boolean addItem = true;
			//Test against Name
			if(!params[0].isEmpty() && !params[0].equals(book.getName())){
				addItem = false;
			}
			//Test against Category
			if(!params[1].equals("Any Category") && !params[1].equals(book.getCategory())){
				addItem = false;
			}
			//Test agains Author
			if(!params[2].isEmpty() && !params[2].equals(book.getAuthor())){
				addItem = false;
			}
			//Test against Title
			if(!params[3].isEmpty() && !params[3].equals(book.getTitle())){
				addItem = false;
			}
			//Add item if it passed tests
			if(addItem){
				foundBooks.add(book);
			}
		}		// TODO Auto-generated method stub
		return foundBooks;
	}

	@Override
	public void removeBook(String isbn) {
		for(Book book : books){
			if(book.getName().equals(isbn)){
				books.remove(book);
			}
		}
		
	}

}
