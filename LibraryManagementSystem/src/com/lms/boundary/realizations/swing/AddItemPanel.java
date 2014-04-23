package com.lms.boundary.realizations.swing;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Rectangle;
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

public class AddItemPanel extends JPanel {
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public AddItemPanel() {
		this.setSize(800, 579);
		setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 36, 194, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 11, 46, 14);
		add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(10, 218, 29, 20);
		add(spinner);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 92, 194, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 67, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Number of Copies");
		lblNewLabel_3.setBounds(10, 193, 119, 14);
		add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(701, 545, 89, 23);
		add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A -- GENERAL WORKS ", "B -- PHILOSOPHY. PSYCHOLOGY. RELIGION ", "C -- AUXILIARY SCIENCES OF HISTORY ", "D -- WORLD HISTORY AND HISTORY OF EUROPE, ASIA, AFRICA, AUSTRALIA, NEW ZEALAND, ETC. ", "E -- HISTORY OF THE AMERICAS ", "F -- HISTORY OF THE AMERICAS ", "G -- GEOGRAPHY. ANTHROPOLOGY. RECREATION ", "H -- SOCIAL SCIENCES ", "J -- POLITICAL SCIENCE ", "K -- LAW ", "L -- EDUCATION ", "M -- MUSIC AND BOOKS ON MUSIC ", "N -- FINE ARTS ", "P -- LANGUAGE AND LITERATURE ", "Q -- SCIENCE ", "R -- MEDICINE", "S -- AGRICULTURE", "T -- TECHNOLOGY", "U -- MILITARY SCIENCE ", "V -- NAVAL SCIENCE ", "Z -- BIBLIOGRAPHY. LIBRARY SCIENCE. INFORMATION RESOURCES (GENERAL) "}));
		comboBox.setBounds(10, 148, 516, 20);
		add(comboBox);
		
		JLabel lblLibraryOfCongress = new JLabel("Library of Congress Classification");
		lblLibraryOfCongress.setBounds(10, 123, 207, 14);
		add(lblLibraryOfCongress);

	}
}
