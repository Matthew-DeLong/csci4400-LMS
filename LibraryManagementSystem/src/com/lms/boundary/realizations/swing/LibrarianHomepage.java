package com.lms.boundary.realizations.swing;

import java.awt.Container;

import javax.swing.JLabel;






import com.lms.LMS;
import com.lms.entity.LibrarianAccount;

import java.awt.Choice;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.JToggleButton;
import java.awt.CardLayout;
import java.awt.Panel;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class LibrarianHomepage extends Container implements ItemListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private LMS frameRef;
	JMenuItem logOut, addItem, addBook, manageItems, manageBooks, checkOutItem, checkOutBook, returnItem, returnBook;
	JPanel panel;
	CardLayout contentPanelLayout;
	private JMenu mnNewMenu_3;
	
	public LibrarianHomepage(LMS lms, LibrarianAccount acct){
		frameRef = lms;	
		frameRef.setTitle("Librarian Homepage");
		setSize(800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 21);
		add(menuBar);
		
		
		JMenu mnLibrarianActions = new JMenu("Librarian Actions");
		menuBar.add(mnLibrarianActions);
		
		JMenu mnNewMenu = new JMenu("Collection Management");
		mnLibrarianActions.add(mnNewMenu);
		
		manageItems = new JMenuItem("Manage Items");
		manageItems.addActionListener(this);
		mnNewMenu.add(manageItems);
		
		manageBooks = new JMenuItem("Manage Books");
		manageBooks.addActionListener(this);
		mnNewMenu.add(manageBooks);
		
		JMenu mnNewMenu_1 = new JMenu("Add");
		mnNewMenu.add(mnNewMenu_1);
		
		addBook = new JMenuItem("Book");
		addBook.addActionListener(this);
		mnNewMenu_1.add(addBook);
		
		addItem = new JMenuItem("Item");
		addItem.addActionListener(this);
		mnNewMenu_1.add(addItem);
		
		JMenu mnNewMenu_2 = new JMenu("Check Out");
		mnLibrarianActions.add(mnNewMenu_2);
		
		checkOutBook = new JMenuItem("Book");
		checkOutBook.addActionListener(this);
		mnNewMenu_2.add(checkOutBook);
		
		checkOutItem = new JMenuItem("Item");
		checkOutItem.addActionListener(this);
		mnNewMenu_2.add(checkOutItem);
		
		mnNewMenu_3 = new JMenu("Return");
		mnLibrarianActions.add(mnNewMenu_3);
		
		returnBook = new JMenuItem("Book");
		returnBook.addActionListener(this);
		mnNewMenu_3.add(returnBook);
		
		returnItem = new JMenuItem("Item");
		returnItem.addActionListener(this);
		mnNewMenu_3.add(returnItem);
		
		JMenu mnAccountActions = new JMenu("Account Actions");
		menuBar.add(mnAccountActions);
		
		logOut = new JMenuItem("Log Out");
		logOut.addActionListener(this);
		mnAccountActions.add(logOut);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mnAccountActions.add(mntmChangePassword);
		
		panel = new JPanel();
		panel.setBounds(0, 21, 800, 579);
		add(panel);
		contentPanelLayout = new CardLayout(0, 0);
		panel.setLayout(contentPanelLayout);
		panel.add(new AddItemPanel(), "ADD_ITEM");
		panel.add(new AddBookPanel(), "ADD_BOOK");
		panel.add(new LibrarianItemManagementPanel(), "MANAGE_ITEMS");
		panel.add(new LibrarianBookManagementPanel(), "MANAGE_BOOKS");
		panel.add(new LibrarianCheckOutItemPanel(), "ITEM_CHECKOUT");
		panel.add(new LibrarianCheckOutBookPanel(), "BOOK_CHECKOUT");
		panel.add(new LibrarianReturnItemPanel(), "ITEM_RETURN");
		panel.add(new LibrarianReturnBookPanel(), "BOOK_RETURN");
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		
		
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.print("Success");
		if(e.getItemSelectable()==logOut){
			System.out.print("Success");
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logOut){
			frameRef.setContentPane(new Login(frameRef));
		}
		if(e.getSource()==addBook){
			contentPanelLayout.show(panel, "ADD_BOOK");
		}
		if(e.getSource()==addItem){
			contentPanelLayout.show(panel, "ADD_ITEM");
		}
		if(e.getSource() == manageItems){
			contentPanelLayout.show(panel, "MANAGE_ITEMS");
		}
		if(e.getSource() == manageBooks){
			contentPanelLayout.show(panel, "MANAGE_BOOKS");
		}
		if(e.getSource() == checkOutItem){
			contentPanelLayout.show(panel, "ITEM_CHECKOUT");
		}
		if(e.getSource() == checkOutBook){
			contentPanelLayout.show(panel, "BOOK_CHECKOUT");
		}
		if(e.getSource() == returnItem){
			contentPanelLayout.show(panel, "ITEM_RETURN");
		}
		if(e.getSource() == returnBook){
			contentPanelLayout.show(panel, "BOOK_RETURN");
		}
	}
}
