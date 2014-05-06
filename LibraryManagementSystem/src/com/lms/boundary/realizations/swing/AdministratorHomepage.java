package com.lms.boundary.realizations.swing;

import java.awt.CardLayout;
import java.awt.Container;





import com.lms.LMS;
import com.lms.entity.AdminAccount;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministratorHomepage extends Container implements ActionListener{

	private static final long serialVersionUID = 1L;
	private LMS frameRef;
	CardLayout contentPanelLayout;
	JPanel panel;
	private JMenu mnNewMenu;
	private JMenuItem viewAllLibrarians;
	private JMenuItem createLibrarianAccount;
	private JMenuItem removeLibrarianAccount;
	private JMenu mnNewMenu_1;
	private JMenuItem viewAllVisitors;
	private JMenuItem removeVisitor;
	private JMenu mnNewMenu_2;
	private JMenuItem logOff;
	private JMenuItem changePassword;

	public AdministratorHomepage(LMS lms, AdminAccount acct){
		frameRef = lms;		
		setSize(800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 21);
		add(menuBar);
		
		mnNewMenu = new JMenu("Manage Librarian Accounts");
		menuBar.add(mnNewMenu);
		
		viewAllLibrarians = new JMenuItem("View All");
		viewAllLibrarians.addActionListener(this);
		mnNewMenu.add(viewAllLibrarians);
		
		createLibrarianAccount = new JMenuItem("Create");
		createLibrarianAccount.addActionListener(this);
		mnNewMenu.add(createLibrarianAccount);
		
		removeLibrarianAccount = new JMenuItem("Remove");
		removeLibrarianAccount.addActionListener(this);
		mnNewMenu.add(removeLibrarianAccount);
		
		mnNewMenu_1 = new JMenu("Manage Visitor Accounts");
		menuBar.add(mnNewMenu_1);
		
		viewAllVisitors = new JMenuItem("View all");
		viewAllVisitors.addActionListener(this);
		mnNewMenu_1.add(viewAllVisitors);
		
		removeVisitor = new JMenuItem("Remove");
		removeVisitor.addActionListener(this);
		mnNewMenu_1.add(removeVisitor);
		
		mnNewMenu_2 = new JMenu("Account Actions");
		menuBar.add(mnNewMenu_2);
		
		logOff = new JMenuItem("Log Off");
		logOff.addActionListener(this);
		mnNewMenu_2.add(logOff);
		
		changePassword = new JMenuItem("Change Password");
		changePassword.addActionListener(this);
		mnNewMenu_2.add(changePassword);
		
		panel = new JPanel();
		panel.setBounds(0, 21, 800, 579);
		add(panel);
		contentPanelLayout = new CardLayout(0, 0);
		panel.setLayout(contentPanelLayout);
		panel.add(new AdminViewAllLibrariansPanel(), "viewLibrarians");
		panel.add(new AdminRemoveLibrarianPanel(), "removeLibrarians");
		panel.add(new AdminCreateLibrarianPanel(), "createLibrarian");
		panel.add(new AdminViewAllVisitors(), "viewMembers");
		panel.add(new AdminDeleteMemberPanel(), "deleteMember");
		//panel.add(new AdminCreateLibrarianPanel(), "createLibrarian");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewAllLibrarians){
			contentPanelLayout.show(panel, "viewLibrarians");			
		}
		if(e.getSource() == createLibrarianAccount){
			contentPanelLayout.show(panel, "createLibrarian");
		}
		if(e.getSource() == removeLibrarianAccount){
			contentPanelLayout.show(panel, "removeLibrarians");
			
		}
		if(e.getSource() == viewAllVisitors){
			contentPanelLayout.show(panel, "viewMembers");
		}
		if(e.getSource() == removeVisitor){
			contentPanelLayout.show(panel, "deleteMember");
			
		}
		if(e.getSource() == changePassword){
			
		}
		if(e.getSource() == logOff){
			frameRef.setContentPane(new Login(frameRef));			
		}
	}
}
