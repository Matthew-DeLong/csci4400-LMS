package com.lms.databaseinterfaces;

import java.util.LinkedList;

import com.lms.entity.Item;

public interface ItemDatabaseInterface {
	
	public void removeItem(String name, String category);
	
	public void addItem(String name, String category, float dailyLateFee, float maxLateFee, int copies);
	
	public void addItem(Item item);

	public Item getItem(String name, String category);
	
	public LinkedList<Item> getItems(String[] params);
	
	public boolean itemExists(String name, String category);
}
