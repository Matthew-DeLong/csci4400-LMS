package com.lms.boundary.realizations.swing;

import java.awt.Container;

import javax.swing.JLabel;

import com.lms.Account;
import com.lms.LMS;

public class LibrarianHomepage extends Container{

	private static final long serialVersionUID = 1L;
	private LMS frameRef;

	
	public LibrarianHomepage(LMS lms, Account acct){
		frameRef = lms;		
		setSize(800, 600);
		
		
		JLabel welcomeLabel = new JLabel("Welcome to the Librarian Homepage");
		welcomeLabel.setBounds(117, 94, 392, 14);
		add(welcomeLabel);
	
	}

}
