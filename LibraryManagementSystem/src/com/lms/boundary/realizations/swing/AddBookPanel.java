package com.lms.boundary.realizations.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.NumberFormatter;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import com.lms.boundary.abstractions.Messagable;
import com.lms.control.LibrarianActionsControl;

public class AddBookPanel extends JPanel implements ActionListener, Messagable{
	private JTextField isbn;
	private JTextField title;
	private JTextField author;
	JLabel feedbackLabel;
	JFormattedTextField dailyFee, maxFee;
	JSpinner numberOfCopies;
	JComboBox category;
	/**
	 * Create the panel.
	 */
	public AddBookPanel() {
		setSize(800, 579);
		setLayout(null);
		
		JLabel label = new JLabel("ISBN:");
		label.setBounds(10, 11, 46, 14);
		add(label);
		
		isbn = new JTextField();
		isbn.setColumns(10);
		isbn.setBounds(10, 36, 390, 20);
		add(isbn);
		
		JLabel label_1 = new JLabel("Library of Congress Classification");
		label_1.setBounds(10, 67, 221, 14);
		add(label_1);
		
		category = new JComboBox();
		category.setModel(new DefaultComboBoxModel(new String[] {"A -- GENERAL WORKS", "B -- PHILOSOPHY. PSYCHOLOGY. RELIGION", "C -- AUXILIARY SCIENCES OF HISTORY", "D -- WORLD HISTORY AND HISTORY OF EUROPE, ASIA, AFRICA, AUSTRALIA, NEW ZEALAND, ETC.", "E -- HISTORY OF THE AMERICAS", "F -- HISTORY OF THE AMERICAS", "G -- GEOGRAPHY. ANTHROPOLOGY. RECREATION", "H -- SOCIAL SCIENCES", "J -- POLITICAL SCIENCE", "K -- LAW", "L -- EDUCATION", "M -- MUSIC AND BOOKS ON MUSIC", "N -- FINE ARTS", "P -- LANGUAGE AND LITERATURE", "Q -- SCIENCE", "R -- MEDICINE", "S -- AGRICULTURE", "T -- TECHNOLOGY", "U -- MILITARY SCIENCE", "V -- NAVAL SCIENCE", "Z -- BIBLIOGRAPHY. LIBRARY SCIENCE. INFORMATION RESOURCES (GENERAL)"}));
		category.setBounds(10, 92, 390, 20);
		add(category);
		
		JLabel label_2 = new JLabel("Title: ");
		label_2.setBounds(10, 123, 88, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("Author: ");
		label_3.setBounds(10, 179, 46, 14);
		add(label_3);
		
		title = new JTextField();
		title.setColumns(10);
		title.setBounds(10, 148, 390, 20);
		add(title);
		
		author = new JTextField();
		author.setColumns(10);
		author.setBounds(10, 204, 390, 20);
		add(author);
		
		//Make TextField formator
		 DecimalFormat decimalFormat = new DecimalFormat("0.00");
		 NumberFormatter textFormatter = new NumberFormatter(decimalFormat);
		 textFormatter.setOverwriteMode(true);
		 textFormatter.setAllowsInvalid(false);
		
		JLabel label_4 = new JLabel("Daily Late Fee: ");
		label_4.setBounds(10, 235, 141, 14);
		add(label_4);
		
		dailyFee = new JFormattedTextField(textFormatter);
		dailyFee.setColumns(10);
		dailyFee.setBounds(10, 260, 86, 20);
		add(dailyFee);
		
		JLabel label_5 = new JLabel("Max Late Fee: ");
		label_5.setBounds(10, 291, 141, 14);
		add(label_5);
		
		maxFee = new JFormattedTextField(textFormatter);
		maxFee.setColumns(10);
		maxFee.setBounds(10, 316, 86, 20);
		add(maxFee);
		
		JLabel label_6 = new JLabel("Number of Copies: ");
		label_6.setBounds(10, 347, 111, 14);
		add(label_6);
		
		numberOfCopies = new JSpinner();
		numberOfCopies.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		numberOfCopies.setBounds(10, 372, 46, 20);
		add(numberOfCopies);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(this);
		addButton.setActionCommand("add");
		addButton.setBounds(10, 403, 187, 23);
		add(addButton);
		
		feedbackLabel = new JLabel("");
		feedbackLabel.setBounds(10, 437, 370, 14);
		add(feedbackLabel);

	}

	@Override
	public void sendMessage(String msg) {
		feedbackLabel.setText(msg);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "add":
			//Set dailyFee and maxFee to zero if the textfields for them are empty
			float dailyFeeValue, maxFeeValue;
			if(dailyFee.getText().isEmpty()){
				dailyFeeValue=-1f;
			}else{
				dailyFeeValue =Float.parseFloat(dailyFee.getText());
			}
			if(maxFee.getText().isEmpty()){
				maxFeeValue=-2f;
			}else{
				maxFeeValue = Float.parseFloat(maxFee.getText());
			}
			LibrarianActionsControl.addBook(this, isbn.getText(),(String) category.getSelectedItem(), author.getText(), title.getText(), dailyFeeValue, maxFeeValue, (int) numberOfCopies.getValue());
			break;
		}
		
	}

}
