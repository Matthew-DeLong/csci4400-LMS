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

public class LibrarianReturnItemPanel extends JPanel implements Messagable, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	JLabel feedbackLabel;
	private JTextField memberField;
	JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public LibrarianReturnItemPanel() {
		setSize(800,579);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Return Item");
		lblNewLabel.setBounds(10, 11, 224, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name: ");
		lblNewLabel_1.setBounds(10, 36, 93, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 61, 368, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Category: ");
		lblNewLabel_2.setBounds(10, 92, 224, 14);
		add(lblNewLabel_2);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A -- GENERAL WORKS", "B -- PHILOSOPHY. PSYCHOLOGY. RELIGION", "C -- AUXILIARY SCIENCES OF HISTORY", "D -- WORLD HISTORY AND HISTORY OF EUROPE, ASIA, AFRICA, AUSTRALIA, NEW ZEALAND, ETC.", "E -- HISTORY OF THE AMERICAS", "F -- HISTORY OF THE AMERICAS", "G -- GEOGRAPHY. ANTHROPOLOGY. RECREATION", "H -- SOCIAL SCIENCES", "J -- POLITICAL SCIENCE", "K -- LAW", "L -- EDUCATION", "M -- MUSIC AND BOOKS ON MUSIC", "N -- FINE ARTS", "P -- LANGUAGE AND LITERATURE", "Q -- SCIENCE", "R -- MEDICINE", "S -- AGRICULTURE", "T -- TECHNOLOGY", "U -- MILITARY SCIENCE", "V -- NAVAL SCIENCE", "Z -- BIBLIOGRAPHY. LIBRARY SCIENCE. INFORMATION RESOURCES (GENERAL)"}));
		comboBox.setBounds(10, 117, 478, 20);
		add(comboBox);
		
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(this);
		returnButton.setActionCommand("return");
		returnButton.setBounds(10, 197, 133, 23);
		add(returnButton);
		
		feedbackLabel = new JLabel("");
		feedbackLabel.setBounds(10, 231, 478, 14);
		add(feedbackLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Member");
		lblNewLabel_3.setBounds(10, 148, 224, 14);
		add(lblNewLabel_3);
		
		memberField = new JTextField();
		memberField.setBounds(10, 166, 368, 20);
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
			LibrarianActionsControl.returnItem(this, textField.getText(), (String) comboBox.getSelectedItem(), memberField.getText());
			break;
		}
		
	}
}