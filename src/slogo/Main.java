package slogo;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import backend.Backend;

import frontend.Canvas;
import frontend.Frontend;

public class Main {
	
	// Constants
	public static final String TITLE = "SLogo";
	
	public static void main(String[]args) {
		
		// Initialize both frontend and backend
		final Frontend fe = new Frontend();
		final Backend be = new Backend();
		
		// Initialize GUI
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}
	
	private static void createAndShowGUI() {
	        JFrame f = new JFrame(TITLE);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.add(new Canvas());
	        f.pack();
	        f.setSize(250,250);
	        f.setVisible(true);
   }
}
