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

import com.lms.boundary.abstractions.Messagable;
import com.lms.control.LibrarianActionsControl;

public class LibrarianViewItemReservationListPanel extends JPanel implements ActionListener{
	private JTable table;
	String type;
	
	public LibrarianViewItemReservationListPanel(String name, String category) {
		setSize(800,579);
		setLayout(null);
		
		type = "MANAGE_ITEMS";
		
		JLabel lblReserveListFor = new JLabel("Reserve List for: ");
		lblReserveListFor.setBounds(10, 11, 222, 14);
		add(lblReserveListFor);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 36, 46, 14);
		add(lblName);
		
		JLabel nameLabel = new JLabel(name);
		nameLabel.setBounds(76, 36, 281, 14);
		add(nameLabel);
		
		JLabel categoryLabel = new JLabel("Category: ");
		categoryLabel.setBounds(10, 61, 80, 14);
		add(categoryLabel);
		
		JLabel lblNewLabel_1 = new JLabel(category);
		lblNewLabel_1.setBounds(76, 61, 281, 14);
		add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 780, 346);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			LibrarianActionsControl.getItemReservationList(name, category),
			new String[] {
				"Number", "Member Name"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		scrollPane.setViewportView(table);
		
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(this);
		returnButton.setActionCommand("return");
		returnButton.setBounds(10, 438, 89, 23);
		add(returnButton);
	}
	
	public LibrarianViewItemReservationListPanel(String name) {
		setSize(800,579);
		setLayout(null);
		
		type = "MANAGE_BOOKS";
		
		JLabel lblReserveListFor = new JLabel("Reserve List for: ");
		lblReserveListFor.setBounds(10, 11, 222, 14);
		add(lblReserveListFor);
		
		JLabel lblName = new JLabel("ISBN:");
		lblName.setBounds(10, 36, 46, 14);
		add(lblName);
		
		JLabel nameLabel = new JLabel(name);
		nameLabel.setBounds(76, 36, 281, 14);
		add(nameLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 780, 346);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			LibrarianActionsControl.getItemReservationList(name),
			new String[] {
				"Number", "Member Name"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		scrollPane.setViewportView(table);
		
		JButton returnButton = new JButton("Return");
		returnButton.addActionListener(this);
		returnButton.setActionCommand("return");
		returnButton.setBounds(10, 438, 89, 23);
		add(returnButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "return":
			CardLayout layout = (CardLayout) this.getParent().getLayout();
			layout.show(this.getParent(), type);
			break;
		}
		
	}

}
