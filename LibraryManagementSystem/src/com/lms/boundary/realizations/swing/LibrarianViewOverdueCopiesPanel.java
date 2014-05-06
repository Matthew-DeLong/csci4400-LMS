package com.lms.boundary.realizations.swing;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import com.lms.control.LibrarianActionsControl;

public class LibrarianViewOverdueCopiesPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public LibrarianViewOverdueCopiesPanel(String name, String category) {
		setSize(800,579);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Overdue Copies of:");
		lblNewLabel.setBounds(10, 11, 199, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name: ");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblCategory = new JLabel("Category: ");
		lblCategory.setBounds(10, 61, 68, 14);
		add(lblCategory);
		
		JLabel nameLabel = new JLabel(name);
		nameLabel.setBounds(66, 36, 365, 14);
		add(nameLabel);
		
		JLabel categoryLabel = new JLabel(category);
		categoryLabel.setBounds(66, 61, 365, 14);
		add(categoryLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 780, 374);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			LibrarianActionsControl.getOverdueCopiesofItem(name, category),
			new String[] {
				"Name of Member", "Days Overdue", "Fees Accumulated"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(this);
		returnButton.setActionCommand("return");
		returnButton.setBounds(10, 471, 122, 23);
		add(returnButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "return":
			CardLayout layout = (CardLayout) this.getParent().getLayout();
			layout.show(this.getParent(), "MANAGE_ITEMS");
			break;
			
		}
		
	}

}
