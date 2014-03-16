package frontend;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import slogo.Controller;

@SuppressWarnings("serial")
public class View extends JFrame{

	private JTabbedPane TABS;
	private int TAB_COUNT = 1;
	private Controller myController;
	private Canvas CURRENT_CANVAS;
	private TabPanel CURRENT_TAB;
	
	//private List<Workspace> myWorkSpaces = new ArrayList<Workspace>();

	public View (Controller c, Dimension bounds) {
		//myResources = ResourceBundle.getBundle();
		myController = c;
		TABS = new JTabbedPane();
		CURRENT_TAB = new TabPanel(myController, this);
		TABS.addTab("Tab" + (TABS.getTabCount() + 1) , CURRENT_TAB);
		this.setJMenuBar(new MenuView(this));
		this.getContentPane().add(TABS);
		
	}

	//we can replace this with message Dialog (popup from JFrame), 
	//take in parameter ResourceBundle/Constants file and search for Error message string
//	public void showMessage (String message) {
//		myHistoryTextArea.append(message + "\n");
//	}
//
//	public void clearCommands () {
//		myHistoryTextArea.append("");
//	}

	public void quit() {
		// TODO Auto-generated method stub
		
	}

	public void saveFile() {
		// TODO Auto-generated method stub
		
	}

	public Canvas getCanvas(){
		return CURRENT_TAB.getCanvas();
	}
	
	public void addTab(){
		TabPanel tab = new TabPanel(myController, this);
		TABS.addTab("Tab" + (TABS.getTabCount() + 1) , tab);
		
	}
}
