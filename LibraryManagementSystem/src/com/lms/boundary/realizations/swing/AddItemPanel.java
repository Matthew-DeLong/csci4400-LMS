package com.lms.boundary.realizations.swing;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Rectangle;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.DecimalFormat;

import javax.swing.JFrame;

import com.lms.boundary.abstractions.Messagable;
import com.lms.control.LibrarianActionsControl;
import javax.swing.SpinnerNumberModel;

public class AddItemPanel extends JPanel implements Messagable, ActionListener{
	private JTextField nameField;
	JLabel feedbackLabel;
	JComboBox comboBox;
	JSpinner spinner;
	private JTextField dailyLateFee;
	private JTextField maxLateFee;
	

	/**
	 * Create the panel.
	 */
	public AddItemPanel() {
		this.setSize(800, 579);
		setLayout(null);
		
		nameField = new JTextField();
		nameField.setBounds(10, 36, 194, 20);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 11, 46, 14);
		add(lblNewLabel);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(10, 263, 56, 20);
		add(spinner);
		
		JLabel lblNewLabel_3 = new JLabel("Number of Copies");
		lblNewLabel_3.setBounds(10, 238, 119, 14);
		add(lblNewLabel_3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A -- GENERAL WORKS", "B -- PHILOSOPHY. PSYCHOLOGY. RELIGION", "C -- AUXILIARY SCIENCES OF HISTORY", "D -- WORLD HISTORY AND HISTORY OF EUROPE, ASIA, AFRICA, AUSTRALIA, NEW ZEALAND, ETC.", "E -- HISTORY OF THE AMERICAS", "F -- HISTORY OF THE AMERICAS", "G -- GEOGRAPHY. ANTHROPOLOGY. RECREATION", "H -- SOCIAL SCIENCES", "J -- POLITICAL SCIENCE", "K -- LAW", "L -- EDUCATION", "M -- MUSIC AND BOOKS ON MUSIC", "N -- FINE ARTS", "P -- LANGUAGE AND LITERATURE", "Q -- SCIENCE", "R -- MEDICINE", "S -- AGRICULTURE", "T -- TECHNOLOGY", "U -- MILITARY SCIENCE", "V -- NAVAL SCIENCE", "Z -- BIBLIOGRAPHY. LIBRARY SCIENCE. INFORMATION RESOURCES (GENERAL)"}));
		comboBox.setBounds(10, 92, 516, 20);
		add(comboBox);
		
		JLabel lblLibraryOfCongress = new JLabel("Library of Congress Classification");
		lblLibraryOfCongress.setBounds(10, 67, 207, 14);
		add(lblLibraryOfCongress);
		
		JButton addItemButton = new JButton("Add Item");
		addItemButton.setActionCommand("ADD_ITEM");
		addItemButton.addActionListener(this);
		addItemButton.setBounds(10, 294, 89, 23);
		add(addItemButton);
		
		feedbackLabel = new JLabel("");
		feedbackLabel.setBounds(10, 328, 459, 14);
		add(feedbackLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Daily Late Fee");
		lblNewLabel_1.setBounds(10, 123, 125, 14);
		add(lblNewLabel_1);
		
		//Make TextField formator
		 DecimalFormat decimalFormat = new DecimalFormat("0.00");
		 NumberFormatter textFormatter = new NumberFormatter(decimalFormat);
		 textFormatter.setOverwriteMode(true);
		 textFormatter.setAllowsInvalid(false);
		 
		dailyLateFee = new JFormattedTextField(textFormatter);
		dailyLateFee.setBounds(10, 148, 86, 20);
		add(dailyLateFee);
		dailyLateFee.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Max Late Fee");
		lblNewLabel_2.setBounds(10, 179, 89, 14);
		add(lblNewLabel_2);
		
		maxLateFee = new JFormattedTextField(textFormatter);
		maxLateFee.setBounds(10, 204, 86, 20);
		add(maxLateFee);
		maxLateFee.setColumns(10);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Add Item Button Clicked
		if(e.getActionCommand().equals("ADD_ITEM")){
			//Set dailyFee and maxFee to zero if the textfields for them are empty
			float dailyFee, maxFee;
			if(dailyLateFee.getText().isEmpty()){
				dailyFee=-1f;
			}else{
				dailyFee =Float.parseFloat(dailyLateFee.getText());
			}
			if(maxLateFee.getText().isEmpty()){
				maxFee=-2f;
			}else{
				maxFee = Float.parseFloat(maxLateFee.getText());
			}
			LibrarianActionsControl.addItem(this, nameField.getText(),(String) comboBox.getSelectedItem(), dailyFee, maxFee, (int) spinner.getValue());
		}		
	}

	@Override
	public void sendMessage(String msg) {
		System.out.println(msg);
		feedbackLabel.setText(msg);
		
	}
}
