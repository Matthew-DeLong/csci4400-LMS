package com.lms.boundary.realizations.swing;

import java.awt.Container;

import javax.swing.JLabel;






import com.lms.LMS;
import com.lms.entity.LibrarianAccount;

import java.awt.Choice;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.JToggleButton;
import java.awt.CardLayout;
import java.awt.Panel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class LibrarianHomepage extends Container implements ItemListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private LMS frameRef;
	JMenuItem mntmLogOut;
	JPanel panel;
	
	
	public LibrarianHomepage(LMS lms, LibrarianAccount acct){
		frameRef = lms;		
		setSize(800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 21);
		add(menuBar);
		
		
		JMenu mnLibrarianActions = new JMenu("Librarian Actions");
		menuBar.add(mnLibrarianActions);
		
		JMenu mnNewMenu = new JMenu("Collection Management");
		mnLibrarianActions.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("View All Items");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmRemove = new JMenuItem("Remove");
		mnNewMenu.add(mntmRemove);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmUpdate = new JMenuItem("Update");
		mnNewMenu.add(mntmUpdate);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Borrowed Items Management");
		mnLibrarianActions.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Check Out");
		mnLibrarianActions.add(mntmNewMenuItem_3);
		
		JMenu mnAccountActions = new JMenu("Account Actions");
		menuBar.add(mnAccountActions);
		
		mntmLogOut = new JMenuItem("Log Out");
		mnAccountActions.add(mntmLogOut);
		mntmLogOut.addItemListener(this);
		mntmLogOut.addActionListener(this);
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mnAccountActions.add(mntmChangePassword);
		
		panel = new JPanel();
		panel.setBounds(0, 21, 800, 579);
		add(panel);
		panel.setLayout(new CardLayout(0, 0));
	
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		
		
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.print("Success");
		if(e.getItemSelectable()==mntmLogOut){
			System.out.print("Success");
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mntmLogOut){
			frameRef.setContentPane(new Login(frameRef));
		}
		
	}
}
