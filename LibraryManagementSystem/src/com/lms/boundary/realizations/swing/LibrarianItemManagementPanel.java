package com.lms.boundary.realizations.swing;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lms.boundary.abstractions.ItemDisplayer;
import com.lms.control.LibrarianActionsControl;

public class LibrarianItemManagementPanel extends JPanel implements ItemDisplayer, ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField textField;
	JTable table;
	JComboBox comboBox;
	
	public LibrarianItemManagementPanel() {
		setSize(800, 579);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Criteria");
		lblNewLabel.setBounds(10, 11, 121, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name: ");
		lblNewLabel_1.setBounds(10, 36, 44, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(64, 33, 238, 20);
		add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Any Category", "A -- GENERAL WORKS", "B -- PHILOSOPHY. PSYCHOLOGY. RELIGION", "C -- AUXILIARY SCIENCES OF HISTORY", "D -- WORLD HISTORY AND HISTORY OF EUROPE, ASIA, AFRICA, AUSTRALIA, NEW ZEALAND, ETC.", "E -- HISTORY OF THE AMERICAS", "F -- HISTORY OF THE AMERICAS", "G -- GEOGRAPHY. ANTHROPOLOGY. RECREATION", "H -- SOCIAL SCIENCES", "J -- POLITICAL SCIENCE", "K -- LAW", "L -- EDUCATION", "M -- MUSIC AND BOOKS ON MUSIC", "N -- FINE ARTS", "P -- LANGUAGE AND LITERATURE", "Q -- SCIENCE", "R -- MEDICINE", "S -- AGRICULTURE", "T -- TECHNOLOGY", "U -- MILITARY SCIENCE", "V -- NAVAL SCIENCE", "Z -- BIBLIOGRAPHY. LIBRARY SCIENCE. INFORMATION RESOURCES (GENERAL)"}));
		comboBox.setBounds(312, 33, 478, 20);
		add(comboBox);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("search");
		btnNewButton.setBounds(10, 61, 89, 23);
		add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 780, 361);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Copies Avaliable", "Total Copies", "Category"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setActionCommand("edit");
		btnNewButton_1.setBounds(10, 467, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remove");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setActionCommand("Remove");
		btnNewButton_2.setBounds(355, 467, 89, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Overdue Copies");
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setActionCommand("View Overdue Copies");
		btnNewButton_3.setBounds(614, 467, 176, 23);
		add(btnNewButton_3);
		
		JButton viewReservationsButton = new JButton("View Reservations");
		viewReservationsButton.addActionListener(this);
		viewReservationsButton.setActionCommand("View Reservations");
		viewReservationsButton.setBounds(614, 501, 176, 23);
		add(viewReservationsButton);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
			case "search":
				LibrarianActionsControl.searchForItems(this, new String[]{textField.getText(), (String) comboBox.getSelectedItem()});
				break;
			case "edit":
				CardLayout layout = (CardLayout) this.getParent().getLayout();
				String name = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);
				String category = (String) table.getModel().getValueAt(table.getSelectedRow(), 3);
				this.getParent().add(new LibrarianEditItemPanel(name, category), "edit");
				layout.show(this.getParent(), "edit");
				clearResults();
				break;
			case "Remove":
				CardLayout layout1 = (CardLayout) this.getParent().getLayout();
				String name1 = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);
				String category1 = (String) table.getModel().getValueAt(table.getSelectedRow(), 3);
				this.getParent().add(new LibrarianRemoveItemPanel(name1, category1), "remove");
				layout1.show(this.getParent(), "remove");
				clearResults();
				break;
			case "View Reservations":
				CardLayout layout11 = (CardLayout) this.getParent().getLayout();
				String name11 = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);
				String category11 = (String) table.getModel().getValueAt(table.getSelectedRow(), 3);
				this.getParent().add(new LibrarianViewItemReservationListPanel(name11, category11), "View Reservations");
				layout11.show(this.getParent(), "View Reservations");
				clearResults();
				break;
			case "View Overdue Copies":
				CardLayout layout111 = (CardLayout) this.getParent().getLayout();
				String name111 = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);
				String category111 = (String) table.getModel().getValueAt(table.getSelectedRow(), 3);
				this.getParent().add(new LibrarianViewOverdueCopiesPanel(name111, category111), "View Overdue");
				layout111.show(this.getParent(), "View Overdue");
				clearResults();
				break;
		}
		
	}


	@Override
	public void displayItems(String[][] items) {
		table.setModel(new DefaultTableModel(
				items,
				new String[] {
					"Name", "Copies Avaliable", "Total Copies", "Category"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		
	}
	
	private void clearResults(){
		//Clear Table
		String[][] table = new String[0][4];
		displayItems(table);
	
	}
}
