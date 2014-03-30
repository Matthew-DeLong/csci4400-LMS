package com.lms.boundary.realizations.swing;

import java.awt.Container;

import com.lms.Account;
import com.lms.LMS;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class AdministratorHomepage extends Container{

	private static final long serialVersionUID = 1L;
	private LMS frameRef;

	public AdministratorHomepage(LMS lms, Account acct){
		frameRef = lms;		
		setSize(800, 600);
		
		
		JLabel welcomeLabel = new JLabel("Welcome to the Administrator Homepage");
		welcomeLabel.setBounds(117, 94, 392, 14);
		add(welcomeLabel);
		
	}
	
}
