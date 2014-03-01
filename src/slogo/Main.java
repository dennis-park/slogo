package slogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import backend.Backend;

import frontend.Canvas;
import frontend.Frontend;

public class Main {

	// Constants
	public static final double DEFAULT_UNIT = 1.0; 
	public static final String TITLE = "SLogo";
	public static final Canvas CANVAS = new Canvas();
	public static final JButton RUN = new JButton("Run");
	public static final JButton PEN = new JButton("Change Pen Color");
	public static final JButton TURTLE = new JButton("Upload A Turtle Image");
	public static final JTextArea CONSOLE = new JTextArea(5, 15);
	public static final JButton FD = new JButton("Foward");
	public static final JButton BK = new JButton("Backward");
	public static final JButton LT = new JButton("Left");
	public static final JButton RT = new JButton("Right");

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

		PEN.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				JColorChooser.showDialog(new JFrame(), "Pick your color", Color.PINK);
			}
		});

		TURTLE.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(CANVAS);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					BufferedImage img = null;
					try {
						img = ImageIO.read(new File(chooser.getSelectedFile().getAbsolutePath()));
						CANVAS.changeTurtle(img);
					} catch (IOException e1) {
					}
				}            
			}
		});

		FD.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				CANVAS.move(DEFAULT_UNIT);
			}
		});

		BK.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				CANVAS.move(-DEFAULT_UNIT);
			}
		});

		LT.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				CANVAS.rotate(DEFAULT_UNIT);
			}
		});

		RT.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				CANVAS.rotate(-DEFAULT_UNIT);
			}
		});

	}

	private static void createAndShowGUI() {		
		
		JFrame f = new JFrame(TITLE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();

		p.setLayout(new BorderLayout());
		p1.setLayout(new GridLayout(0,1));
		p2.setLayout(new GridLayout(2,2));

		p.add(CONSOLE);

		p1.add(RUN);
		p1.add(PEN);
		p1.add(TURTLE);

		p2.add(FD);
		p2.add(BK);
		p2.add(LT);
		p2.add(RT);

		f.add(CANVAS, BorderLayout.NORTH);
		f.add(p, BorderLayout.WEST);
		f.add(p1, BorderLayout.EAST);
		f.add(p2, BorderLayout.SOUTH);

		f.pack();
		f.setVisible(true);
	}
}
