package com.lms.boundary.realizations.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.lms.boundary.abstractions.Messagable;
import com.lms.control.AdminActionsControl;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminRemoveLibrarianPanel extends JPanel implements Messagable, ActionListener{
	private JTextField nameField;
	JLabel feedbackLabel;

	/**
	 * Create the panel.
	 */
	public AdminRemoveLibrarianPanel() {
		setSize(800,579);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove Librarian");
		lblNewLabel.setBounds(10, 11, 227, 14);
		add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setBounds(10, 61, 398, 20);
		add(nameField);
		nameField.setColumns(10);
		
		JButton removeButton = new JButton("Remove");
		removeButton.addActionListener(this);
		removeButton.setActionCommand("remove");
		removeButton.setBounds(10, 92, 89, 23);
		add(removeButton);
		
		feedbackLabel = new JLabel("");
		feedbackLabel.setBounds(10, 126, 398, 14);
		add(feedbackLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name: ");
		lblNewLabel_1.setBounds(10, 36, 291, 14);
		add(lblNewLabel_1);

	}

	@Override
	public void sendMessage(String msg) {
		feedbackLabel.setText(msg);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "remove":
			AdminActionsControl.removeLibrarian(this, nameField.getText());
			break;
		}
		
	}
}
