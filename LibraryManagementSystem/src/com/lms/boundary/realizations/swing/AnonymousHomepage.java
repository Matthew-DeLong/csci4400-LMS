package com.lms.boundary.realizations.swing;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.lms.LMS;

public class AnonymousHomepage extends Container implements ActionListener{

	private static final long serialVersionUID = 1L;
	private LMS frameRef;
	JMenuItem searchItems, searchBooks, register, logOff;
	CardLayout contentPanelLayout;
	JPanel panel;
	
	public AnonymousHomepage(LMS lms){
		frameRef = lms;		
		setSize(800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 21);
		add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Items");
		menuBar.add(mnNewMenu);
		
		searchItems = new JMenuItem("Search Items");
		searchItems.addActionListener(this);
		mnNewMenu.add(searchItems);
		
		JMenu mnNewMenu_1 = new JMenu("Books");
		menuBar.add(mnNewMenu_1);
		
		searchBooks = new JMenuItem("Search Books");
		searchBooks.addActionListener(this);
		mnNewMenu_1.add(searchBooks);
		
		JMenu mnNewMenu_3 = new JMenu("Account Actions");
		menuBar.add(mnNewMenu_3);
		
		register = new JMenuItem("Register");
		register.addActionListener(this);
		mnNewMenu_3.add(register);
		
		logOff = new JMenuItem("Log Off");
		logOff.addActionListener(this);
		mnNewMenu_3.add(logOff);
		
		panel = new JPanel();
		panel.setBounds(0, 21, 800, 579);
		add(panel);
		contentPanelLayout = new CardLayout(0, 0);
		panel.setLayout(contentPanelLayout);
		panel.add(new AnonymousSearchBooksPanel(), "searchBooks");
		panel.add(new RegistrationPanel(), "registration");
		panel.add(new AnonymousSearchItemsPanel(), "searchItems");
		
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == register){
			contentPanelLayout.show(panel, "registration");
		}
		if(e.getSource() == logOff){
			frameRef.setContentPane(new Login(frameRef));
		}
		if(e.getSource() == searchBooks){
			contentPanelLayout.show(panel, "searchBooks");
		}
		if(e.getSource() == searchItems){
			contentPanelLayout.show(panel, "searchItems");
		}
	}
}
