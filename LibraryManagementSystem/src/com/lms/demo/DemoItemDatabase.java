package com.lms.demo;

import java.util.LinkedList;

import com.lms.databaseinterfaces.ItemDatabaseInterface;
import com.lms.entity.Item;

public class DemoItemDatabase implements ItemDatabaseInterface{
	
	LinkedList<Item> items = new LinkedList<Item>();
	
	public DemoItemDatabase(){
		items = new LinkedList<Item>(); 
		items.add(new Item("IPad", "A -- GENERAL WORKS", 1.5f, 2f, 3));
		items.add(new Item("Phaser Beam", "T -- TECHNOLOGY", 1.5f, 2f, 3));
		Item test = new Item("test", "A -- GENERAL WORKS",1.5f,3f,6);
		test.addReservation("Bob");
		test.addOverdueCopy(5);
		items.add(test);
		
	}

	@Override
	public Item getItem(String name, String category) {
		for(Item item: items){
			if(item.getName().equals(name) && item.getCategory().equals(category)){
				System.out.println("Item found!");
				return item;
			}
		}
		return null;
	}


	@Override
	public void removeItem(String name, String category) {
		for(Item item: items){
			if(item.getName().equals(name) && item.getCategory().equals(category)){
				items.remove(item);
			}
		}
		
	}

	@Override
	public void addItem(String name, String category, float dailyLateFee,
			float maxLateFee, int copies) {
		items.add(new Item(name, category, dailyLateFee, maxLateFee, copies));
		
	}
	
	public void addItem(Item item){
		items.add(item);
	}

	@Override
	public LinkedList<Item> getItems(String[] params) {
		LinkedList<Item> foundItems = new LinkedList<Item>();
		for(Item item : items){			
			boolean addItem = true;
			//Test against Name
			if(!params[0].isEmpty() && !params[0].equals(item.getName())){
				addItem = false;
			}
			//Test against Category
			if(!params[1].equals("Any Category") && !params[1].equals(item.getCategory())){
				addItem = false;
			}
			//Add item if it passed tests
			if(addItem){
				foundItems.add(item);
			}
		}
		return foundItems;
	}


	@Override
	public boolean itemExists(String name, String category) {
		boolean itemExists = false;
		for(Item item: items){
			if(item.getName().equals(name) && item.getCategory().equals(category)){
				itemExists = true;
			};
		}
		return itemExists;
	}

}
