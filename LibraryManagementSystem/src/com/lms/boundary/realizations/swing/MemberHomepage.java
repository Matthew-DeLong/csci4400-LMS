package com.lms.boundary.realizations.swing;

import java.awt.Container;

import javax.swing.JLabel;






import com.lms.LMS;
import com.lms.entity.Account;

import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberHomepage extends Container implements ActionListener{

	private static final long serialVersionUID = 1L;
	private LMS frameRef;
	JMenuItem borrowedItems, searchItems, reservedItems, borrowedBooks, searchBooks, reservedBooks, payFees, logOff;
	CardLayout contentPanelLayout;
	JPanel panel;
	
	public MemberHomepage(LMS lms, Account acct){
		frameRef = lms;		
		setSize(800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 21);
		add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Items");
		menuBar.add(mnNewMenu);
		
		borrowedItems = new JMenuItem("My Borrowed Items");
		borrowedItems.addActionListener(this);
		mnNewMenu.add(borrowedItems);
		
		searchItems = new JMenuItem("Search Items");
		searchItems.addActionListener(this);
		mnNewMenu.add(searchItems);
		
		reservedItems = new JMenuItem("Reserved Items");
		reservedItems.addActionListener(this);
		mnNewMenu.add(reservedItems);
		
		JMenu mnNewMenu_1 = new JMenu("Books");
		menuBar.add(mnNewMenu_1);
		
		borrowedBooks = new JMenuItem("My Borrowed Books");
		borrowedBooks.addActionListener(this);
		mnNewMenu_1.add(borrowedBooks);
		
		searchBooks = new JMenuItem("Search Books");
		searchBooks.addActionListener(this);
		mnNewMenu_1.add(searchBooks);
		
		reservedBooks = new JMenuItem("Reserved Books");
		reservedBooks.addActionListener(this);
		mnNewMenu_1.add(reservedBooks);
		
		JMenu mnNewMenu_2 = new JMenu("View/Pay Fees");
		menuBar.add(mnNewMenu_2);
		
		payFees = new JMenuItem("View/Pay Fees");
		payFees.addActionListener(this);
		mnNewMenu_2.add(payFees);
		
		JMenu mnNewMenu_3 = new JMenu("Account Actions");
		menuBar.add(mnNewMenu_3);
		
		logOff = new JMenuItem("Log Off");
		logOff.addActionListener(this);
		mnNewMenu_3.add(logOff);
		
		panel = new JPanel();
		panel.setBounds(0, 21, 800, 579);
		add(panel);
		contentPanelLayout = new CardLayout(0, 0);
		panel.setLayout(contentPanelLayout);
		panel.add(new MemberViewBorrowedItemsPanel(acct.getName()), "borrowedItems");
		panel.add(new MemberViewBorrowedBooksPanel(acct.getName()), "borrowedBooks");
		panel.add(new MemberSearchItemsPanel(acct.getName()), "searchItems");
		panel.add(new MemberSearchBooksPanel(acct.getName()), "searchBooks");
		panel.add(new MemberViewReservedBooksPanel(acct.getName()), "reservedBooks");
		panel.add(new MemberViewReservedItemsPanel(acct.getName()), "reservedItems");
		//panel.add(new MemberViewLateFeesPanel(acct.getName()), "latefees");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logOff){
			frameRef.setContentPane(new Login(frameRef));
		}
		if(e.getSource() == searchItems){
			contentPanelLayout.show(panel, "searchItems");
		}
		if(e.getSource() == searchBooks){
			contentPanelLayout.show(panel, "searchBooks");
		}
		if(e.getSource() == borrowedItems){
			contentPanelLayout.show(panel, "borrowedItems");
		}
		if(e.getSource() == borrowedBooks){
			contentPanelLayout.show(panel, "borrowedBooks");
		}
		if(e.getSource() == reservedBooks){
			contentPanelLayout.show(panel, "reservedBooks");
		}
		if(e.getSource() == reservedItems){
			contentPanelLayout.show(panel, "reservedItems");
		}
	}
}