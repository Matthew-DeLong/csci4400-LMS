package com.lms.boundary.realizations.swing;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

import com.lms.boundary.abstractions.Messagable;
import com.lms.control.LibrarianActionsControl;

public class LibrarianEditItemPanel extends JPanel implements ActionListener, Messagable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
	JLabel errorMessages;
	String[] oldItemInformation;
	JFormattedTextField dailyLateFeeField, maxLateFeeField;
	JComboBox categoryComboBox;
	JSpinner numberOfCopiesSpinner;
	
	public LibrarianEditItemPanel(String itemName, String itemCategory){
		setSize(800, 579);
		setLayout(null);
		
		oldItemInformation = LibrarianActionsControl.getItemInformation(itemName, itemCategory);
		
		JLabel lblNewLabel = new JLabel("Old Information");
		lblNewLabel.setBounds(10, 11, 151, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New Information");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setBounds(455, 11, 114, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setBounds(10, 36, 46, 14);
		add(lblNewLabel_2);
		
		JLabel oldName = new JLabel("New label");
		oldName.setText(oldItemInformation[0]);
		oldName.setBounds(10, 61, 181, 14);
		add(oldName);
		
		JLabel lblLibraryOfCongress = new JLabel("Library of Congress Classification:");
		lblLibraryOfCongress.setBounds(10, 86, 246, 14);
		add(lblLibraryOfCongress);
		
		JLabel oldCategory = new JLabel("New label");
		oldCategory.setText(oldItemInformation[1]);
		oldCategory.setBounds(10, 111, 181, 14);
		add(oldCategory);
		
		JLabel lblNewLabel_5 = new JLabel("Daily Late Fee:");
		lblNewLabel_5.setBounds(10, 136, 124, 14);
		add(lblNewLabel_5);
		
		JLabel oldDailyFee = new JLabel("New label");
		oldDailyFee.setText(oldItemInformation[2]);
		oldDailyFee.setBounds(10, 161, 181, 14);
		add(oldDailyFee);
		
		JLabel lblNewLabel_7 = new JLabel("Max Late Fee:");
		lblNewLabel_7.setBounds(10, 186, 114, 14);
		add(lblNewLabel_7);
		
		JLabel oldMaxFee = new JLabel("New label");
		oldMaxFee.setText(oldItemInformation[3]);
		oldMaxFee.setBounds(10, 211, 151, 14);
		add(oldMaxFee);
		
		JLabel lblNumberOfCopies = new JLabel("Number of Copies:");
		lblNumberOfCopies.setBounds(10, 236, 114, 14);
		add(lblNumberOfCopies);
		
		JLabel oldCopies = new JLabel("New label");
		oldCopies.setText(oldItemInformation[4]);
		oldCopies.setBounds(10, 261, 151, 14);
		add(oldCopies);
		
		JLabel lblNewLabel_10 = new JLabel("Name:");
		lblNewLabel_10.setBounds(455, 36, 46, 14);
		add(lblNewLabel_10);
		
		nameField = new JTextField();
		nameField.setBounds(455, 58, 194, 20);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Library of Congress Classification: ");
		lblNewLabel_11.setBounds(455, 86, 194, 14);
		add(lblNewLabel_11);
		
		categoryComboBox = new JComboBox();
		categoryComboBox.setModel(new DefaultComboBoxModel(new String[] {"A -- GENERAL WORKS", "B -- PHILOSOPHY. PSYCHOLOGY. RELIGION", "C -- AUXILIARY SCIENCES OF HISTORY", "D -- WORLD HISTORY AND HISTORY OF EUROPE, ASIA, AFRICA, AUSTRALIA, NEW ZEALAND, ETC.", "E -- HISTORY OF THE AMERICAS", "F -- HISTORY OF THE AMERICAS", "G -- GEOGRAPHY. ANTHROPOLOGY. RECREATION", "H -- SOCIAL SCIENCES", "J -- POLITICAL SCIENCE", "K -- LAW", "L -- EDUCATION", "M -- MUSIC AND BOOKS ON MUSIC", "N -- FINE ARTS", "P -- LANGUAGE AND LITERATURE", "Q -- SCIENCE", "R -- MEDICINE", "S -- AGRICULTURE", "T -- TECHNOLOGY", "U -- MILITARY SCIENCE", "V -- NAVAL SCIENCE", "Z -- BIBLIOGRAPHY. LIBRARY SCIENCE. INFORMATION RESOURCES (GENERAL)"}));
		categoryComboBox.setBounds(455, 108, 335, 20);
		add(categoryComboBox);
		
		//Make TextField formator
		 DecimalFormat decimalFormat = new DecimalFormat("0.00");
		 NumberFormatter textFormatter = new NumberFormatter(decimalFormat);
		 textFormatter.setOverwriteMode(true);
		 textFormatter.setAllowsInvalid(false);
		
		JLabel label = new JLabel("Daily Late Fee:");
		label.setBounds(455, 136, 124, 14);
		add(label);
		
		dailyLateFeeField = new JFormattedTextField(textFormatter);
		dailyLateFeeField.setColumns(10);
		dailyLateFeeField.setBounds(455, 158, 86, 20);
		add(dailyLateFeeField);
		
		JLabel label_1 = new JLabel("Max Late Fee:");
		label_1.setBounds(455, 186, 114, 14);
		add(label_1);
		
		maxLateFeeField = new JFormattedTextField(textFormatter);
		maxLateFeeField.setColumns(10);
		maxLateFeeField.setBounds(455, 208, 86, 20);
		add(maxLateFeeField);
		
		numberOfCopiesSpinner = new JSpinner();
		numberOfCopiesSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		numberOfCopiesSpinner.setBounds(455, 258, 46, 20);
		add(numberOfCopiesSpinner);
		
		JLabel label_2 = new JLabel("Number of Copies:");
		label_2.setBounds(455, 236, 114, 14);
		add(label_2);
		
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(this);
		returnButton.setActionCommand("return");
		returnButton.setBounds(10, 520, 150, 23);
		add(returnButton);
		
		JButton editButton = new JButton("Edit");
		editButton.addActionListener(this);
		editButton.setActionCommand("edit");
		editButton.setBounds(640, 520, 150, 23);
		add(editButton);
		
		errorMessages = new JLabel("");
		errorMessages.setBounds(317, 289, 473, 14);
		add(errorMessages);
	}


	@Override
	public void sendMessage(String msg) {
		errorMessages.setText(msg);		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "return":
			CardLayout layout = (CardLayout) this.getParent().getLayout();
			layout.show(this.getParent(), "MANAGE_ITEMS");
			break;
		case "edit":
			//Set dailyFee and maxFee to zero if the textfields for them are empty
			float dailyFee, maxFee;
			if(dailyLateFeeField.getText().isEmpty()){
				dailyFee=-1f;
			}else{
				dailyFee =Float.parseFloat(dailyLateFeeField.getText());
			}
			if(maxLateFeeField.getText().isEmpty()){
				maxFee=-2f;
			}else{
				maxFee = Float.parseFloat(maxLateFeeField.getText());
			}
			LibrarianActionsControl.editItem(this, oldItemInformation[0], oldItemInformation[1], nameField.getText(),(String) categoryComboBox.getSelectedItem(), dailyFee, maxFee, (int) numberOfCopiesSpinner.getValue());
			break;
		}
		
	}
}
