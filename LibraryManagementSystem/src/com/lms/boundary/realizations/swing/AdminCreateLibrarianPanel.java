package com.lms.boundary.realizations.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.lms.boundary.abstractions.Messagable;
import com.lms.control.AdminActionsControl;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminCreateLibrarianPanel extends JPanel implements Messagable, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel feedbackLabel;

	/**
	 * Create the panel.
	 */
	public AdminCreateLibrarianPanel() {
		setSize(800,579);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Librarian Account");
		lblNewLabel.setBounds(10, 11, 328, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 61, 328, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name: ");
		lblNewLabel_1.setBounds(10, 36, 130, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password: ");
		lblNewLabel_2.setBounds(10, 92, 165, 14);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 117, 328, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton createAccountButton = new JButton("Create");
		createAccountButton.addActionListener(this);
		createAccountButton.setActionCommand("create");
		createAccountButton.setBounds(10, 148, 89, 23);
		add(createAccountButton);
		
		feedbackLabel = new JLabel("");
		feedbackLabel.setBounds(10, 182, 318, 14);
		add(feedbackLabel);

	}

	@Override
	public void sendMessage(String msg) {
		feedbackLabel.setText(msg);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "create":
			AdminActionsControl.addLibrarian(this, textField.getText(), textField_1.getText());
			break;
		}
	}

}
