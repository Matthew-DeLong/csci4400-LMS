package com.lms.boundary.realizations.swing;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import com.lms.boundary.abstractions.Messagable;
import com.lms.control.LibrarianActionsControl;
import javax.swing.SwingConstants;

public class LibrarianRemoveBookPanel extends JPanel implements ActionListener, Messagable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String isbn;
	JLabel feedbackLabel;
	
	public LibrarianRemoveBookPanel(String isbn) {
		setSize(800,579);
		setLayout(null);
		
		String[] info = LibrarianActionsControl.getBookInformation(isbn);
		this.isbn = isbn;
		
		JLabel lblNewLabel = new JLabel("Are you sure you want to remove this book?");
		lblNewLabel.setBounds(10, 11, 251, 14);
		add(lblNewLabel);
		
		JLabel label = new JLabel("ISBN:");
		label.setBounds(10, 36, 177, 14);
		add(label);
		
		JLabel isbnLabel = new JLabel(info[0]);
		isbnLabel.setBounds(10, 61, 397, 14);
		add(isbnLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Title:");
		lblNewLabel_3.setBounds(10, 86, 177, 14);
		add(lblNewLabel_3);
		
		JLabel titleLabel = new JLabel(info[5]);
		titleLabel.setBounds(10, 111, 397, 14);
		add(titleLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Author");
		lblNewLabel_5.setBounds(10, 136, 177, 14);
		add(lblNewLabel_5);
		
		JLabel authorLabel = new JLabel(info[6]);
		authorLabel.setBounds(10, 161, 397, 14);
		add(authorLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setBounds(10, 186, 177, 14);
		add(lblNewLabel_1);
		
		JLabel categoryLabel = new JLabel(info[1]);
		categoryLabel.setBounds(10, 211, 397, 14);
		add(categoryLabel);
		
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(this);
		returnButton.setActionCommand("no");
		returnButton.setBounds(10, 501, 89, 23);
		add(returnButton);
		
		JButton yesButton = new JButton("Yes");
		yesButton.addActionListener(this);
		yesButton.setActionCommand("yes");
		yesButton.setBounds(701, 501, 89, 23);
		add(yesButton);
		
		feedbackLabel = new JLabel("");
		feedbackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		feedbackLabel.setBounds(208, 476, 384, 14);
		add(feedbackLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "yes":
			LibrarianActionsControl.removeBook(this, isbn);
			break;
		case "no":
			CardLayout layout = (CardLayout) this.getParent().getLayout();
			layout.show(this.getParent(), "MANAGE_BOOKS");
			break;
		}
		
	}

	@Override
	public void sendMessage(String msg) {
		feedbackLabel.setText(msg);
		
	}

}
