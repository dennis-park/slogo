package slogo;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import backend.Backend;

import frontend.Canvas;
import frontend.Frontend;

public class Main {
	
	// Constants
	public static final String TITLE = "SLogo";
	public static final Canvas CANVAS = new Canvas();
	public static final Backend BACKEND = new Backend();
	public static final JButton RUN = new JButton("Run");
	public static final JButton PEN = new JButton("Change Pen Color");
	public static final JButton TURTLE = new JButton("Upload A Turtle Image");
	public static final JTextArea CONSOLE = new JTextArea(5, 15);
	
	public static void main(String[]args) {
		
		// Initialize both frontend and backend
		final Backend be = new Backend();
		final Frontend fe = new Frontend(CANVAS, be);
		
	
		
		
		// Initialize GUI
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
                createAndShowGUI();
                
            }
        });
		
		// Button listens for mouse click
		RUN.addActionListener(new ActionListener() {
         	 
            public void actionPerformed(ActionEvent e)
            {
               String s = CONSOLE.getText();
               be.sendCommand(s);
            }
        });
		
	}
	
	private static void createAndShowGUI() {		
    
	        JFrame f = new JFrame(TITLE);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        JPanel p = new JPanel();
	        JPanel p1 = new JPanel();
	        GridLayout experimentLayout = new GridLayout(0,1);
	        p.setLayout(new BorderLayout());
	        p.add(CONSOLE, BorderLayout.WEST);
	        p.add(RUN, BorderLayout.EAST);
	        p.add(PEN, BorderLayout.EAST);
	        p.add(TURTLE, BorderLayout.EAST);
	        f.add(CANVAS, BorderLayout.NORTH);
	        f.getContentPane().add(p, BorderLayout.EAST);
	        f.pack();
	        f.setVisible(true);
   }
}
