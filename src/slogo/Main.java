package slogo;

import java.awt.Dimension;
import javax.swing.JFrame;
import backend.Backend;

import frontend.Frontend;
import frontend.View;

public class Main {
		
	public static View VIEW;

	public static void main(String[]args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		// Initialize both frontend and backend
		final Controller c = new Controller();
		final Backend be = new Backend(c);
		final Frontend fe = new Frontend(c);
		c.instantiate(be, fe);
		VIEW =  new View(fe, c, new Dimension(500,500));

		// Initialize GUI
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		VIEW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VIEW.pack();
		VIEW.setVisible(true);
	}
}
