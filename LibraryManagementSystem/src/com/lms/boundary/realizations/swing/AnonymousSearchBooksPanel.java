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
import com.lms.control.LibrarianActionsControl;

public class AnonymousSearchBooksPanel extends JPanel implements ItemDisplayer, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField isbnField;
	private JTextField authorField;
	private JTextField titleField;
	private JTable table;
	JComboBox comboBox;
	
	public AnonymousSearchBooksPanel() {
		setSize(800,579);
		setLayout(null);
		
		JLabel lblSearchCriteria = new JLabel("Search Criteria");
		lblSearchCriteria.setBounds(10, 11, 126, 14);
		add(lblSearchCriteria);
		
		JLabel lblNewLabel = new JLabel("ISBN:");
		lblNewLabel.setBounds(10, 36, 43, 14);
		add(lblNewLabel);
		
		isbnField = new JTextField();
		isbnField.setBounds(63, 33, 250, 20);
		add(isbnField);
		isbnField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Any Category", "A -- GENERAL WORKS", "B -- PHILOSOPHY. PSYCHOLOGY. RELIGION", "C -- AUXILIARY SCIENCES OF HISTORY", "D -- WORLD HISTORY AND HISTORY OF EUROPE, ASIA, AFRICA, AUSTRALIA, NEW ZEALAND, ETC.", "E -- HISTORY OF THE AMERICAS", "F -- HISTORY OF THE AMERICAS", "G -- GEOGRAPHY. ANTHROPOLOGY. RECREATION", "H -- SOCIAL SCIENCES", "J -- POLITICAL SCIENCE", "K -- LAW", "L -- EDUCATION", "M -- MUSIC AND BOOKS ON MUSIC", "N -- FINE ARTS", "P -- LANGUAGE AND LITERATURE", "Q -- SCIENCE", "R -- MEDICINE", "S -- AGRICULTURE", "T -- TECHNOLOGY", "U -- MILITARY SCIENCE", "V -- NAVAL SCIENCE", "Z -- BIBLIOGRAPHY. LIBRARY SCIENCE. INFORMATION RESOURCES (GENERAL)"}));
		comboBox.setBounds(323, 33, 467, 20);
		add(comboBox);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(10, 67, 46, 14);
		add(lblAuthor);
		
		JLabel lblNewLabel_1 = new JLabel("Title:");
		lblNewLabel_1.setBounds(323, 67, 46, 14);
		add(lblNewLabel_1);
		
		authorField = new JTextField();
		authorField.setBounds(63, 64, 250, 20);
		add(authorField);
		authorField.setColumns(10);
		
		titleField = new JTextField();
		titleField.setBounds(379, 64, 411, 20);
		add(titleField);
		titleField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 780, 356);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ISBN", "Title", "Author", "Copies Avaliable", "Total Copies", "Category"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(this);
		searchButton.setActionCommand("search");
		searchButton.setBounds(10, 92, 89, 23);
		add(searchButton);
	}
	@Override
	public void displayItems(String[][] items) {
		table.setModel(new DefaultTableModel(
				items,
				new String[] {
					"ISBN", "Title", "Author", "Copies Avaliable", "Total Copies", "Category"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "search":
			LibrarianActionsControl.searchForBooks(this, new String[]{isbnField.getText(), (String) comboBox.getSelectedItem(), authorField.getText(), titleField.getText()});
			break;
		}
	}
	

	
}
