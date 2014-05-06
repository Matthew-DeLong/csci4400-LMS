package com.lms.boundary.realizations.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.lms.boundary.abstractions.Messagable;
import com.lms.control.MemberActionsControl;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegistrationPanel extends JPanel implements Messagable, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
	private JTextField passwordField;
	private JTextField addressField;
	JLabel feedbackLabel;

	public RegistrationPanel() {
		setSize(800,579);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(10, 11, 140, 14);
		add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setBounds(10, 36, 199, 20);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(10, 67, 140, 14);
		add(lblPassword);
		
		passwordField = new JTextField();
		passwordField.setBounds(10, 88, 199, 20);
		add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		lblNewLabel_1.setBounds(10, 119, 121, 14);
		add(lblNewLabel_1);
		
		addressField = new JTextField();
		addressField.setBounds(10, 144, 199, 20);
		add(addressField);
		addressField.setColumns(10);
		
		feedbackLabel = new JLabel("");
		feedbackLabel.setBounds(10, 175, 413, 14);
		add(feedbackLabel);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(this);
		registerButton.setActionCommand("register");
		registerButton.setBounds(10, 200, 89, 23);
		add(registerButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "register":
			MemberActionsControl.addAccount(this, nameField.getText(), passwordField.getText(), addressField.getText());
			break;
		}
		
	}

	@Override
	public void sendMessage(String msg) {
		feedbackLabel.setText(msg);
		
	}
}
