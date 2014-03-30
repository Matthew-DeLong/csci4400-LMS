package com.lms;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.lms.boundary.realizations.swing.Login;



public class LMS extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public LMS() {
		setTitle("LMS");
		setResizable(false);
		setSize(800,600);
		setContentPane(new Login(this));
		setVisible(true);
	}

	

	public static void main(String[] args){
	    SwingUtilities.invokeLater(new Runnable() {

	        @Override
	        public void run() {
	            LMS lsm = new LMS();
	            
	        }
	    });
		
	 
	}
	
}
