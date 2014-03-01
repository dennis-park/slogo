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
	
	private JComponent makeInfoPanel() {
		JPanel myTurtleInfo = new JPanel();
		myTurtleInfo.setLayout(new BorderLayout());	

		myPosition = new JLabel();
		myHeading = new JLabel();

		myTurtleInfo.add(myPosition);
		myTurtleInfo.add(myHeading);
		
		updateHeading(myTurtle.getHeading());
		updatePosition(myTurtle.getX(), myTurtle.getY());
		
		return myTurtleInfo;
	}
	
	private JLabel myHistory;
	private JTextArea myHistoryArea;
	private JScrollPane myScrollable;
	private static final int DEFAULT_FIELD = 30;

	
	private JComponent makeCommandHistory() {
		JPanel myCommandHistory = new JPanel();
		myCommandHistory.setLayout(new BorderLayout());
		
		//replace getName = command list
		myHistory = new JLabel(myResources.getString(getName()));
		
        myCommandHistory.add(myHistory, BorderLayout.CENTER);
        myHistoryArea = new JTextArea(DEFAULT_FIELD, DEFAULT_FIELD);
        myHistoryArea.setEditable(false);
        
        myScrollable = new JScrollPane(myHistoryArea);
        
        myCommandHistory.add(myScrollable);
        myCommandHistory.add(myScrollable, BorderLayout.CENTER);

        return myCommandHistory;
	}

	private void updatePosition(double x, double y) {
		// TODO Auto-generated method stub
		
	}

	private void updateHeading(double heading) {
		// TODO Auto-generated method stub
		
	}


}
