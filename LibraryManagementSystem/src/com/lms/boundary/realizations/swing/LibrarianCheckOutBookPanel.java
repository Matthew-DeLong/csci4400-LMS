package com.lms.boundary.realizations.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.lms.boundary.abstractions.Messagable;
import com.lms.control.LibrarianActionsControl;

public class LibrarianCheckOutBookPanel extends JPanel implements Messagable, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField isbnField;
	private JTextField memberName;
	JLabel feedbackLabel;

	/**
	 * Create the panel.
	 */
	public LibrarianCheckOutBookPanel() {
		setSize(800, 579);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Check Out Book");
		lblNewLabel.setBounds(10, 11, 401, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN: ");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		add(lblNewLabel_1);
		
		isbnField = new JTextField();
		isbnField.setBounds(10, 61, 401, 20);
		add(isbnField);
		isbnField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Member Name");
		lblNewLabel_2.setBounds(10, 92, 401, 14);
		add(lblNewLabel_2);
		
		memberName = new JTextField();
		memberName.setBounds(10, 117, 401, 20);
		add(memberName);
		memberName.setColumns(10);
		
		JButton checkOut = new JButton("Check Out");
		checkOut.addActionListener(this);
		checkOut.setActionCommand("checkOut");
		checkOut.setBounds(10, 148, 121, 23);
		add(checkOut);
		
		feedbackLabel = new JLabel("");
		feedbackLabel.setBounds(10, 182, 401, 14);
		add(feedbackLabel);
		
	}

	@Override
	public void sendMessage(String msg) {
		feedbackLabel.setText(msg);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "checkOut":
			LibrarianActionsControl.checkOutBook(this, isbnField.getText(), memberName.getText());
			break;
		}
		
	}
		
	
}
