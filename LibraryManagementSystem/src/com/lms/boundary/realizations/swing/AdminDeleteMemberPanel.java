package com.lms.boundary.realizations.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.lms.boundary.abstractions.Messagable;
import com.lms.control.AdminActionsControl;

public class AdminDeleteMemberPanel extends JPanel implements Messagable, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
	JLabel feedbackLabel;

	/**
	 * Create the panel.
	 */
	public AdminDeleteMemberPanel() {
		setSize(800,579);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Member Account");
		lblNewLabel.setBounds(10, 11, 312, 14);
		add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setBounds(10, 61, 395, 20);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name: ");
		lblNewLabel_1.setBounds(10, 36, 86, 14);
		add(lblNewLabel_1);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(this);
		deleteButton.setActionCommand("delete");
		deleteButton.setBounds(10, 92, 89, 23);
		add(deleteButton);
		
		feedbackLabel = new JLabel("");
		feedbackLabel.setBounds(10, 126, 395, 14);
		add(feedbackLabel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "delete":
			AdminActionsControl.removeMember(this, nameField.getText());
		break;
		}
		
	}

	@Override
	public void sendMessage(String msg) {
		feedbackLabel.setText(msg);
		
	}

}
