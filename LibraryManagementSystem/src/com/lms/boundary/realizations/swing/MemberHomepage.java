package com.lms.boundary.realizations.swing;

import java.awt.Container;

import javax.swing.JLabel;

import com.lms.Account;
import com.lms.LMS;

public class MemberHomepage extends Container{

	private static final long serialVersionUID = 1L;
	private LMS frameRef;

	
	public MemberHomepage(LMS lms, Account acct){
		frameRef = lms;		
		setSize(800, 600);
		
		
		JLabel welcomeLabel = new JLabel("Welcome to the Member Homepage");
		welcomeLabel.setBounds(117, 94, 392, 14);
		add(welcomeLabel);
	
	}

}