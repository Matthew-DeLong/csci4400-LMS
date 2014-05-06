package com.lms.boundary.realizations.swing;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.lms.boundary.abstractions.ItemDisplayer;
import com.lms.boundary.abstractions.Messagable;
import com.lms.control.LibrarianActionsControl;
import com.lms.control.MemberActionsControl;

public class MemberSearchItemsPanel extends JPanel implements ItemDisplayer, Messagable, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField textField;
	JTable table;
	JComboBox comboBox;
	String memberName;
	JLabel feedbackLabel;

	/**
	 * Create the panel.
	 */
	public MemberSearchItemsPanel(String memberName) {
		setSize(800, 579);
		setLayout(null);
		
		this.memberName = memberName;
		
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
		
		JButton reserveItem = new JButton("Reserve Item");
		reserveItem.addActionListener(this);
		reserveItem.setActionCommand("reserve");
		reserveItem.setBounds(614, 467, 176, 23);
		add(reserveItem);
		
		feedbackLabel = new JLabel("");
		feedbackLabel.setBounds(10, 471, 594, 14);
		add(feedbackLabel);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
			case "search":
				LibrarianActionsControl.searchForItems(this, new String[]{textField.getText(), (String) comboBox.getSelectedItem()});
				break;
			case "reserve":
				String name = (String) table.getModel().getValueAt(table.getSelectedRow(), 0);
				String category = (String) table.getModel().getValueAt(table.getSelectedRow(), 3);
				MemberActionsControl.reserveItem(this, memberName, name, category);
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
	


	@Override
	public void sendMessage(String msg) {
		feedbackLabel.setText(msg);
		
	}
}