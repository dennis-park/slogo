package frontend;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuView extends JMenuBar{
	private View myView;
	private JMenu myFiles;
	private JMenu myPreferences;
	private JMenu myHelp;

	public MenuView(View v) {
		myView = v;
		addMenus();
	}

	private void addMenus() {
		this.add(fileMenu());
		this.add(preferencesMenu());
		this.add(helpMenu());
	}
	private JMenu preferencesMenu() {
		// TODO Auto-generated method stub
		return myPreferences;
	}

	private JMenu fileMenu() {

		return myFiles;

	}
	private JMenu helpMenu() {

		return myHelp;

	}

}
