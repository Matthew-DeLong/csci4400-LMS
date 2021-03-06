package com.lms.boundary.realizations.swing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lms.control.AdminActionsControl;

public class AdminViewAllVisitors extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public AdminViewAllVisitors() {
		setSize(800,579);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View all Members");
		lblNewLabel.setBounds(10, 11, 222, 14);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 780, 394);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			AdminActionsControl.getVisitors(),
			new String[] {
				"Name", "Address"
			}
		));
		scrollPane.setViewportView(table);

	}

}
