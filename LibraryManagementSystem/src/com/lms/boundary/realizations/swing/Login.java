package com.lms.boundary.realizations.swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.sound.sampled.Control;
import javax.swing.JLabel;



import com.lms.LMS;
import com.lms.boundary.abstractions.LoginBoundaryAbstraction;
import com.lms.control.LoginControl;
import com.lms.entity.Account;
import com.lms.entity.AdminAccount;
import com.lms.entity.LibrarianAccount;
import com.lms.entity.MemberAccount;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.JFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class Login extends Container implements LoginBoundaryAbstraction, ActionListener, InternalFrameListener{

	
	private static final long serialVersionUID = 1L;
	private LMS frameRef;
	private JTextField passwordTextField;
	private JTextField usernameTextField;
	private LoginControl control;
	private JComboBox userTypeSelect;
	private JInternalFrame internalFrame;
	private JButton loginButton;
	
	public Login(LMS lms) {
		frameRef = lms;
		frameRef.setTitle("LMS - Login");
		
		control = new LoginControl(this);
		
		internalFrame = new JInternalFrame("Login Error");
		internalFrame.addInternalFrameListener(this);
		internalFrame.setVisible(false);
		internalFrame.setClosable(true);
		internalFrame.setBounds(229, 187, 342, 226);
		add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JLabel lblSorryThereWas = new JLabel("Sorry, there was an error logging you in.");
		lblSorryThereWas.setHorizontalAlignment(SwingConstants.CENTER);
		lblSorryThereWas.setBounds(10, 49, 306, 14);
		internalFrame.getContentPane().add(lblSorryThereWas);
		
		JLabel lblAreYouSure = new JLabel("Are you sure you entered the correct information?");
		lblAreYouSure.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreYouSure.setBounds(10, 91, 306, 14);
		internalFrame.getContentPane().add(lblAreYouSure);
		JLabel lblHelloPanes = new JLabel("Welcome to the Library Management System!");
		lblHelloPanes.setBounds(31, 26, 372, 14);
		add(lblHelloPanes);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(325, 290, 150, 20);
		add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setBounds(195, 293, 113, 14);
		add(passwordLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(325, 259, 150, 20);
		add(usernameTextField);
		usernameTextField.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setBounds(164, 262, 144, 14);
		add(usernameLabel);
		
		userTypeSelect = new JComboBox();
		userTypeSelect.setModel(new DefaultComboBoxModel(new String[] {"Anonymous", "Member", "Librarian", "Administrator"}));
		userTypeSelect.setBounds(325, 327, 150, 20);
		add(userTypeSelect);
		
		loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		loginButton.setActionCommand("login");
		loginButton.setBounds(325, 358, 150, 23);
		add(loginButton);

	}
	@Override
	public void actionPerformed(ActionEvent event) {
		switch(event.getActionCommand()){
			case "login":
				control.login(usernameTextField.getText(), passwordTextField.getText(), (String) userTypeSelect.getSelectedItem());
			break;
		}
		
	}
	@Override
	public void displayLoginError() {
		internalFrame.toFront();
		internalFrame.setVisible(true);
		loginButton.setVisible(false);
		
		
	}
	
	
	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void internalFrameClosed(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void internalFrameClosing(InternalFrameEvent arg0) {
		loginButton.setVisible(true);
		
	}
	@Override
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void internalFrameIconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void openAdminHomepage(AdminAccount acct) {
		frameRef.setContentPane(new AdministratorHomepage(frameRef, acct));
		
	}
	@Override
	public void openLibrarainHomepage(LibrarianAccount acct) {
		frameRef.setContentPane(new LibrarianHomepage(frameRef, acct));
		
	}
	@Override
	public void openMemeberHomepage(MemberAccount acct) {
		frameRef.setContentPane(new MemberHomepage(frameRef, acct));
		
	}
	@Override
	public void openAnonymousHomepage() {
		frameRef.setContentPane(new AnonymousHomepage(frameRef));
		
	}
}
