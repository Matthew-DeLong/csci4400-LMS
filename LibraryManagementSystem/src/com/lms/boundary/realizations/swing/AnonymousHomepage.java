package com.lms.boundary.realizations.swing;

import java.awt.Container;

import javax.swing.JLabel;

import com.lms.Account;
import com.lms.LMS;

public class AnonymousHomepage extends Container{

	private static final long serialVersionUID = 1L;
	private LMS frameRef;

	
	public AnonymousHomepage(LMS lms){
		frameRef = lms;		
		setSize(800, 600);
		
		
		JLabel welcomeLabel = new JLabel("Welcome Visitor!");
		welcomeLabel.setBounds(117, 94, 392, 14);
		add(welcomeLabel);
	
	}

}
