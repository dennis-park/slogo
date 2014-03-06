package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import slogo.Controller;

public class View extends JFrame{
	private JTabbedPane myTabs;
	private int myWorkspaceCount = 0;
	private Dimension myBounds;
	private ResourceBundle myResources;
	private String myTitle;
	private Controller myController;
	
	
	public static final double DEFAULT_UNIT = 1.0; 

	public static final Canvas CANVAS = new Canvas();

	public static final JTextArea CONSOLE = new JTextArea(5, 15);

	// Buttons
	public static final JButton RUN = new JButton("Run");
	public static final JButton PEN = new JButton("Change Pen Color");
	public static final JButton TURTLE = new JButton("Upload A Turtle Image");
	public static final JButton FD = new JButton("Foward");
	public static final JButton BK = new JButton("Backward");
	public static final JButton LT = new JButton("Left");
	public static final JButton RT = new JButton("Right");

	//private List<Workspace> myWorkSpaces = new ArrayList<Workspace>();

	public View (Frontend fe, Controller c, Dimension bounds) {
		myBounds = bounds;
		myTitle = "";
		//myResources = ResourceBundle.getBundle();
		myTabs = new JTabbedPane();
		myController = c;
		this.getContentPane().add(myTabs);
		
		//other methods after refactoring ie. initGUI()

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
		
		this.add(CANVAS, BorderLayout.NORTH);
		this.add(p, BorderLayout.WEST);
		this.add(p1, BorderLayout.EAST);
		this.add(p2, BorderLayout.SOUTH);
		CANVAS.setEnabled(isEnabled());
		buttonListeners();
	}

	private JLabel myPosition, myHeading;
	private Turtle myTurtle;
	private JTextArea myInfo;

	private JComponent makeInfoPanel() {
		JPanel myTurtleInfo = new JPanel();
		myTurtleInfo.setLayout(new BorderLayout());	
		myInfo = new JTextArea();

		myPosition = new JLabel();
		myHeading = new JLabel();

		myTurtleInfo.add(myPosition);
		myTurtleInfo.add(myHeading);

		updateHeading(myTurtle.getHeading());
		updatePosition(myTurtle.getX(), myTurtle.getY());

		return myTurtleInfo;
	}

	private JLabel myHistory;
	private JTextArea myHistoryTextArea;
	private JScrollPane myScrollable;
	private static final int DEFAULT_FIELD = 30;


	private JComponent makeCommandHistory() {
		JPanel myCommandHistory = new JPanel();
		myCommandHistory.setLayout(new BorderLayout());

		//replace getName = command list
		myHistory = new JLabel(myResources.getString(getName()));

		myCommandHistory.add(myHistory, BorderLayout.CENTER);
		myHistoryTextArea = new JTextArea(DEFAULT_FIELD, DEFAULT_FIELD);
		myHistoryTextArea.setEditable(false);

		myScrollable = new JScrollPane(myHistoryTextArea);

		myCommandHistory.add(myScrollable);
		myCommandHistory.add(myScrollable, BorderLayout.CENTER);

		return myCommandHistory;
	}

	private void updatePosition(double x, double y) {
		myInfo.setText("Position: x=" + x + "\t y=" + y);
	}

	private void updateHeading(double heading) {
		myInfo.setText("Heading=" + heading);
	}

	private void buttonListeners() {
		RUN.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				String s = CONSOLE.getText();
				try {
					myController.sendText(s);
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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

	//we can replace this with message Dialog (popup from JFrame), 
	//take in parameter ResourceBundle/Constants file and search for Error message string
	public void showMessage (String message) {
		myHistoryTextArea.append(message + "\n");
	}

	public void clearCommands () {
		myHistoryTextArea.append("");
	}
	

}
