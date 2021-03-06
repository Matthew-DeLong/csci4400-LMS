package com.lms.boundary.realizations.swing;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lms.boundary.abstractions.ItemDisplayer;
import com.lms.control.MemberActionsControl;

public class MemberViewBorrowedBooksPanel extends JPanel implements ItemDisplayer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	String memberName;
	JLabel feedbackLabel;





	/**
	 * Create the panel.
	 */
	public MemberViewBorrowedBooksPanel(String memberName){
		setSize(800, 579);
		setLayout(null);
		
		this.memberName = memberName;
		
		
		JLabel lblNewLabel = new JLabel("Borrowed Books");
		lblNewLabel.setBounds(10, 11, 121, 14);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 780, 361);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			MemberActionsControl.getBorrowedBooks(this, memberName),
			new String[] {
				"ISBN", "Category", "Due Date"
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
		
		feedbackLabel = new JLabel("");
		feedbackLabel.setBounds(10, 471, 594, 14);
		add(feedbackLabel);
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
	
}