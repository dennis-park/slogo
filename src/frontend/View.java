package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ResourceBundle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class View extends JFrame{
	private Canvas myCanvas;
	private JTabbedPane myTabs;
	private int myWorkspaceCount = 0;
	private Dimension myBounds;
	private ResourceBundle myResources;
	private String myTitle;
	//private List<Workspace> myWorkSpaces = new ArrayList<Workspace>();

	/**
	 * main = workspace for now, refactor into jframe view
	 */
	public View (Dimension bounds) {
		myBounds = bounds;
		myTitle = "";
		//myResources = ResourceBundle.getBundle();
		myTabs = new JTabbedPane();
		this.getContentPane().add(myTabs);
		//other methods after refactoring ie. initGUI()

		new JPanel().add(myCanvas);
		myCanvas.setEnabled(isEnabled());;
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
	
	//we can replace this with message Dialog (popup from JFrame), 
	//take in parameter ResourceBundle/Constants file and search for Error message string
	public void showMessage (String message) {
        myHistoryTextArea.append(message + "\n");
    }

    public void clearCommands () {
    	myHistoryTextArea.append("");
    }
}
