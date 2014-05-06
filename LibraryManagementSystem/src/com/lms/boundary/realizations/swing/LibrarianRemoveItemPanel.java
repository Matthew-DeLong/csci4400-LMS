package com.lms.boundary.realizations.swing;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import com.lms.boundary.abstractions.Messagable;
import com.lms.control.LibrarianActionsControl;

public class LibrarianRemoveItemPanel extends JPanel implements ActionListener, Messagable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel feedbackLabel;
	String name, category;

	public LibrarianRemoveItemPanel(String itemName, String itemCategory){
		setSize(800, 579);
		setLayout(null);
		
		name = itemName;
		category = itemCategory;
		
		JLabel lblNewLabel = new JLabel("Are you sure you want to remove this item?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 24, 263, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name: ");
		lblNewLabel_1.setBounds(10, 49, 318, 14);
		add(lblNewLabel_1);
		
		JLabel nameLabel = new JLabel("New label");
		nameLabel.setText(itemName);
		nameLabel.setBounds(10, 74, 345, 14);
		add(nameLabel);
		
		JLabel label2 = new JLabel("Category: ");
		label2.setBounds(10, 99, 205, 14);
		add(label2);
		
		JLabel categoryLabel = new JLabel("New label");
		categoryLabel.setText(itemCategory);
		categoryLabel.setBounds(10, 124, 414, 14);
		add(categoryLabel);
		
		JButton yesButton = new JButton("Yes");
		yesButton.addActionListener(this);
		yesButton.setActionCommand("yes");
		yesButton.setBounds(701, 501, 89, 23);
		add(yesButton);
		
		JButton noButton = new JButton("Return");
		noButton.addActionListener(this);
		noButton.setActionCommand("no");
		noButton.setBounds(10, 501, 89, 23);
		add(noButton);
		
		feedbackLabel = new JLabel("");
		feedbackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		feedbackLabel.setBounds(222, 449, 355, 14);
		add(feedbackLabel);
	}

	@Override
	public void sendMessage(String msg) {
		feedbackLabel.setText(msg);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "yes":
			LibrarianActionsControl.removeItem(this, name, category);
			break;
		case "no":
			CardLayout layout = (CardLayout) this.getParent().getLayout();
			layout.show(this.getParent(), "MANAGE_ITEMS");
			break;
		}
		
	}
}
