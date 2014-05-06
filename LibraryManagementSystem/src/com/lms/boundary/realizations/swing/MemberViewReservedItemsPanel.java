package com.lms.boundary.realizations.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import com.lms.boundary.abstractions.ItemDisplayer;
import com.lms.boundary.abstractions.Messagable;
import com.lms.control.MemberActionsControl;

public class MemberViewReservedItemsPanel extends JPanel implements ActionListener, ItemDisplayer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	String username;

	/**
	 * Create the panel.
	 */
	public MemberViewReservedItemsPanel(String name) {
		setSize(800,579);
		setLayout(null);
		
		username = name;
		
		JLabel lblNewLabel = new JLabel("View Reserved Items");
		lblNewLabel.setBounds(10, 11, 378, 14);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 36, 770, 368);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Category"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton unreserve = new JButton("Unreserve");
		unreserve.addActionListener(this);
		unreserve.setActionCommand("unreserve");
		unreserve.setBounds(588, 415, 202, 23);
		add(unreserve);
		MemberActionsControl.getReservedItems(this, username);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "unreserve":			
			if(table.getSelectedRow()!=-1){
			MemberActionsControl.unreserveItem((String) table.getModel().getValueAt(table.getSelectedRow(), 0),(String) table.getModel().getValueAt(table.getSelectedRow(), 1), username);
			}
			MemberActionsControl.getReservedItems(this, username);
			break;
		}
		
	}

	

	@Override
	public void displayItems(String[][] items) {
		table.setModel(new DefaultTableModel(
			items,
			new String[] {
				"Name", "Category"
			}
		));
		
	}
}
