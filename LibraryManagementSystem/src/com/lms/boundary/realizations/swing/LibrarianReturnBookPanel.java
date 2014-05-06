package com.lms.boundary.realizations.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lms.boundary.abstractions.Messagable;
import com.lms.control.LibrarianActionsControl;

public class LibrarianReturnBookPanel extends JPanel implements Messagable, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	JLabel feedbackLabel;
	private JTextField memberField;

	/**
	 * Create the panel.
	 */
	public LibrarianReturnBookPanel() {
		setSize(800,579);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Return Book");
		lblNewLabel.setBounds(10, 11, 224, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN:");
		lblNewLabel_1.setBounds(10, 36, 93, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 61, 368, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(this);
		returnButton.setActionCommand("return");
		returnButton.setBounds(10, 148, 133, 23);
		add(returnButton);
		
		feedbackLabel = new JLabel("");
		feedbackLabel.setBounds(10, 182, 478, 14);
		add(feedbackLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Member");
		lblNewLabel_3.setBounds(10, 92, 224, 14);
		add(lblNewLabel_3);
		
		memberField = new JTextField();
		memberField.setBounds(10, 117, 368, 20);
		add(memberField);
		memberField.setColumns(10);

	}

	@Override
	public void sendMessage(String msg) {
		feedbackLabel.setText(msg);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "return":
			LibrarianActionsControl.returnBook(this, textField.getText(), memberField.getText());
			break;
		}
		
	}
}