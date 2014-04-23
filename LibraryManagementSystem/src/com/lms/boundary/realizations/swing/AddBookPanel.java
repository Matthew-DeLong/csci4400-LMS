package com.lms.boundary.realizations.swing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddBookPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public AddBookPanel() {
		setSize(800, 579);
		setLayout(null);
		
		JLabel lblName = new JLabel("Title");
		lblName.setBounds(10, 11, 46, 14);
		add(lblName);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Author");
		lblNewLabel.setBounds(10, 67, 46, 14);
		add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 92, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);

	}

}
