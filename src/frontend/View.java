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

@SuppressWarnings("serial")
public class View extends JFrame{

	private JTabbedPane myTabs;
	private int myWorkspaceCount = 0;
	private ResourceBundle myResources;
	private Controller myController;
	private JLabel myPosition, myHeading, myId;

	public static int DEFAULT_ID = 0;
	public static final double DEFAULT_UNIT = 1.0; 
	private static int DEFAULT_WIDTH = 500;
	private static int DEFAULT_HEIGHT = 500;
	private static int WIDTH_OFFSET = DEFAULT_WIDTH/2;
	private static int HEIGHT_OFFSET = DEFAULT_HEIGHT/2;

	public static final Canvas CANVAS = new Canvas(DEFAULT_WIDTH, DEFAULT_HEIGHT);

	public static final JTextArea CONSOLE = new JTextArea(5, 15);

	// Buttons
	public static final JButton RUN = new JButton("Run");
	public static final JButton PEN = new JButton("Change Pen Color");
	public static final JButton TURTLE = new JButton("Upload A Turtle Image");
	public static final JButton ADD_TURTLE = new JButton("Add a Turtle");
	public static final JButton FD = new JButton("Foward");
	public static final JButton BK = new JButton("Backward");
	public static final JButton LT = new JButton("Left");
	public static final JButton RT = new JButton("Right");

	//private List<Workspace> myWorkSpaces = new ArrayList<Workspace>();

	public View (Controller c, Dimension bounds) {
		//myResources = ResourceBundle.getBundle();
		myTabs = new JTabbedPane();
		myController = c;
		this.getContentPane().add(myTabs);

		JComponent infoPanel = makeInfoPanel();
		// JComponent commandHistory = makeCommandHistory();
		JComponent movementButtons = makeMovementButtons();
		JComponent consolePanel = makeConsolePanel();

		CANVAS.setView(this);

		this.add(CANVAS, BorderLayout.NORTH);
		this.add(consolePanel, BorderLayout.CENTER);
		this.add(movementButtons, BorderLayout.SOUTH);
		this.add(infoPanel, BorderLayout.EAST);
		CANVAS.setEnabled(isEnabled());
		buttonListeners();
	}

	private JComponent makeConsolePanel() {
		JPanel myConsolePanel = new JPanel();
		JPanel myConsole = new JPanel();
		JPanel myControls = new JPanel();

		myConsolePanel.setLayout(new BorderLayout());
		myControls.setLayout(new GridLayout (0,1));

		myConsole.add(CONSOLE);
		myControls.add(RUN);
		myControls.add(PEN);
		myControls.add(TURTLE);
		myControls.add(ADD_TURTLE);

		myConsolePanel.add(myConsole, BorderLayout.WEST);
		myConsolePanel.add(myControls, BorderLayout.EAST);

		return myConsolePanel;
	}

	private JComponent makeMovementButtons() {
		JPanel myMovementButtons = new JPanel();
		myMovementButtons.setLayout(new GridLayout(2,2));
		myMovementButtons.add(FD);
		myMovementButtons.add(BK);
		myMovementButtons.add(LT);
		myMovementButtons.add(RT);
		return myMovementButtons;
	}

	private JComponent makeInfoPanel() {
		JPanel myTurtleInfo = new JPanel();
		myTurtleInfo.setLayout(new GridLayout(3,0));	

		myPosition = new JLabel();
		myHeading = new JLabel();
		myId = new JLabel();

		updateId(CANVAS.getTurtle(DEFAULT_ID).getId());
		updateHeading(CANVAS.getTurtle(DEFAULT_ID).getHeading());
		updatePosition(CANVAS.getTurtle(DEFAULT_ID).getX()-(WIDTH_OFFSET), HEIGHT_OFFSET-CANVAS.getTurtle(DEFAULT_ID).getY());

		myTurtleInfo.add(myPosition);
		myTurtleInfo.add(myHeading);
		myTurtleInfo.add(myId);

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

	private void updateId(int id) {
		myId.setText("Turtle Id = " + id);
	}

	public void updatePosition(double x, double y) {
		myPosition.setText("<html> Turtle x = " + x + "<br/>" + "Turtle y = " + y + "</html>");
	}

	public void updateHeading(double heading) {
		myHeading.setText("Heading = " + heading);
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
				Color newColor = JColorChooser.showDialog(new JFrame(), "Pick your color", Color.PINK);
				if (newColor != null) {
				    CANVAS.getTurtle(DEFAULT_ID).getPen().changeColor(newColor);
				}
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
						CANVAS.getTurtle(DEFAULT_ID).changeTurtle(img);
						CANVAS.repaint();
					} catch (IOException e1) {
					}
				}            
			}
		});

		ADD_TURTLE.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				CANVAS.addTurtle();
			}
		});

		FD.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				CANVAS.getTurtle(DEFAULT_ID).move(DEFAULT_UNIT);
				CANVAS.repaint();
			}
		});

		BK.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				CANVAS.getTurtle(DEFAULT_ID).move(-DEFAULT_UNIT);
				CANVAS.repaint();

			}
		});

		LT.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				CANVAS.getTurtle(DEFAULT_ID).rotate(-DEFAULT_UNIT);
				CANVAS.repaint();
			}
		});

		RT.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				CANVAS.getTurtle(DEFAULT_ID).rotate(DEFAULT_UNIT);
				CANVAS.repaint();
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

	public void quit() {
		// TODO Auto-generated method stub
		
	}

	public void saveFile() {
		// TODO Auto-generated method stub
		
	}

	public Canvas getCanvas(){
		return CANVAS;
	}
}
