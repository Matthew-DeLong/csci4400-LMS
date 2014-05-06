package com.lms.boundary.realizations.swing;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.text.NumberFormatter;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import com.lms.boundary.abstractions.Messagable;
import com.lms.control.LibrarianActionsControl;

public class LibrarianEditBookPanel extends JPanel implements Messagable, ActionListener{
	
	private JTextField newISBN;
	private JTextField newTitle;
	private JTextField newAuthor;
	String[] oldInformation;
	JComboBox comboBox;
	JSpinner newNumberOfCopies;
	JFormattedTextField newDailyLateFee, newMaxLateFee;
	JLabel feedbackLabel;
	 
	public LibrarianEditBookPanel(String isbn) {
		setSize(800,579);
		setLayout(null);
		
		oldInformation = LibrarianActionsControl.getBookInformation(isbn);
		
		JLabel lblNewLabel = new JLabel("Old Information");
		lblNewLabel.setBounds(10, 11, 111, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN:");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		add(lblNewLabel_1);
		
		JLabel oldISBNLabel = new JLabel(oldInformation[0]);
		oldISBNLabel.setBounds(10, 61, 300, 14);
		add(oldISBNLabel);
		
		JLabel lblLibraryOfCongress = new JLabel("Library of Congress Classification");
		lblLibraryOfCongress.setBounds(10, 86, 221, 14);
		add(lblLibraryOfCongress);
		
		JLabel oldCategoryLabel = new JLabel(oldInformation[1]);
		oldCategoryLabel.setBounds(10, 109, 300, 14);
		add(oldCategoryLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Title: ");
		lblNewLabel_2.setBounds(10, 134, 88, 14);
		add(lblNewLabel_2);
		
		JLabel oldTitleLabel = new JLabel(oldInformation[5]);
		oldTitleLabel.setBounds(10, 159, 300, 14);
		add(oldTitleLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Author: ");
		lblNewLabel_3.setBounds(10, 184, 46, 14);
		add(lblNewLabel_3);
		
		JLabel oldAuthorLabel = new JLabel(oldInformation[6]);
		oldAuthorLabel.setBounds(10, 209, 300, 14);
		add(oldAuthorLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Daily Late Fee: ");
		lblNewLabel_4.setBounds(10, 234, 141, 14);
		add(lblNewLabel_4);
		
		JLabel oldDailyLateFee = new JLabel(oldInformation[2]);
		oldDailyLateFee.setBounds(10, 259, 46, 14);
		add(oldDailyLateFee);
		
		JLabel lblNewLabel_5 = new JLabel("Max Late Fee: ");
		lblNewLabel_5.setBounds(10, 284, 141, 14);
		add(lblNewLabel_5);
		
		JLabel oldMaxLateFee = new JLabel(oldInformation[3]);
		oldMaxLateFee.setBounds(10, 309, 300, 14);
		add(oldMaxLateFee);
		
		JLabel lblNewLabel_7 = new JLabel("Number of Copies: ");
		lblNewLabel_7.setBounds(10, 334, 111, 14);
		add(lblNewLabel_7);
		
		JLabel oldNumberOfCopies = new JLabel(oldInformation[4]);
		oldNumberOfCopies.setBounds(10, 359, 300, 14);
		add(oldNumberOfCopies);
		
		JLabel lblNewLabel_6 = new JLabel("New Information");
		lblNewLabel_6.setBounds(400, 11, 349, 14);
		add(lblNewLabel_6);
		
		JLabel label = new JLabel("ISBN:");
		label.setBounds(400, 36, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Library of Congress Classification");
		label_1.setBounds(400, 86, 221, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("Title: ");
		label_2.setBounds(400, 134, 88, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("Author: ");
		label_3.setBounds(400, 184, 46, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("Daily Late Fee: ");
		label_4.setBounds(400, 234, 141, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("Max Late Fee: ");
		label_5.setBounds(400, 284, 141, 14);
		add(label_5);
		
		JLabel label_6 = new JLabel("Number of Copies: ");
		label_6.setBounds(400, 334, 111, 14);
		add(label_6);
		
		newISBN = new JTextField();
		newISBN.setBounds(400, 58, 390, 20);
		add(newISBN);
		newISBN.setColumns(10);
		
		newTitle = new JTextField();
		newTitle.setColumns(10);
		newTitle.setBounds(400, 156, 390, 20);
		add(newTitle);
		
		newAuthor = new JTextField();
		newAuthor.setColumns(10);
		newAuthor.setBounds(400, 206, 390, 20);
		add(newAuthor);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A -- GENERAL WORKS", "B -- PHILOSOPHY. PSYCHOLOGY. RELIGION", "C -- AUXILIARY SCIENCES OF HISTORY", "D -- WORLD HISTORY AND HISTORY OF EUROPE, ASIA, AFRICA, AUSTRALIA, NEW ZEALAND, ETC.", "E -- HISTORY OF THE AMERICAS", "F -- HISTORY OF THE AMERICAS", "G -- GEOGRAPHY. ANTHROPOLOGY. RECREATION", "H -- SOCIAL SCIENCES", "J -- POLITICAL SCIENCE", "K -- LAW", "L -- EDUCATION", "M -- MUSIC AND BOOKS ON MUSIC", "N -- FINE ARTS", "P -- LANGUAGE AND LITERATURE", "Q -- SCIENCE", "R -- MEDICINE", "S -- AGRICULTURE", "T -- TECHNOLOGY", "U -- MILITARY SCIENCE", "V -- NAVAL SCIENCE", "Z -- BIBLIOGRAPHY. LIBRARY SCIENCE. INFORMATION RESOURCES (GENERAL)"}));
		comboBox.setBounds(400, 106, 390, 20);
		add(comboBox);
		
		//Make TextField formator
		 DecimalFormat decimalFormat = new DecimalFormat("0.00");
		 NumberFormatter textFormatter = new NumberFormatter(decimalFormat);
		 textFormatter.setOverwriteMode(true);
		 textFormatter.setAllowsInvalid(false);
		
		newDailyLateFee = new JFormattedTextField(textFormatter);
		newDailyLateFee.setColumns(10);
		newDailyLateFee.setBounds(400, 256, 86, 20);
		add(newDailyLateFee);
		
		newMaxLateFee = new JFormattedTextField(textFormatter);
		newMaxLateFee.setColumns(10);
		newMaxLateFee.setBounds(400, 306, 86, 20);
		add(newMaxLateFee);
		
		newNumberOfCopies = new JSpinner();
		newNumberOfCopies.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		newNumberOfCopies.setBounds(400, 356, 46, 20);
		add(newNumberOfCopies);
		
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(this);
		returnButton.setActionCommand("Return");
		returnButton.setBounds(10, 500, 150, 23);
		add(returnButton);
		
		JButton editButton = new JButton("Edit");
		editButton.addActionListener(this);
		editButton.setActionCommand("Edit");
		editButton.setBounds(640, 500, 150, 23);
		add(editButton);
		
		feedbackLabel = new JLabel("");
		feedbackLabel.setBounds(400, 387, 390, 14);
		add(feedbackLabel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Return":
			CardLayout layout = (CardLayout) this.getParent().getLayout();
			layout.show(this.getParent(), "MANAGE_BOOKS");
			break;
		case "Edit":
			//Set dailyFee and maxFee to zero if the textfields for them are empty
			float dailyFeeValue, maxFeeValue;
			if(newDailyLateFee.getText().isEmpty()){
				dailyFeeValue=-1f;
			}else{
				dailyFeeValue =Float.parseFloat(newDailyLateFee.getText());
			}
			if(newMaxLateFee.getText().isEmpty()){
				maxFeeValue=-2f;
			}else{
				maxFeeValue = Float.parseFloat(newMaxLateFee.getText());
			}
			LibrarianActionsControl.editBook(this, oldInformation[0], newISBN.getText(),(String) comboBox.getSelectedItem(), newAuthor.getText(), newTitle.getText(), dailyFeeValue, maxFeeValue, (int) newNumberOfCopies.getValue());
			break;
		}
		
	}
	@Override
	public void sendMessage(String msg) {
		feedbackLabel.setText(msg);
		
	}
}
