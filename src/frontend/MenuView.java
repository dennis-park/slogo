package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MenuView extends JMenuBar{
	private static View myView;
	private JMenu myFiles;
	private JMenu myPreferences;
	private JMenu myHelp;
	private Canvas myCanvas;

	public MenuView(View v) {
		myView = v;
		myCanvas = v.CANVAS;
		addMenus();
	}

	private void addMenus() {
        this.add(createFilesMenu());
        this.add(createPreferencesMenu());
        this.add(createHelpMenu());
    }

	private JMenu createHelpMenu() {

		return myHelp;

	}

    private JMenu createPreferencesMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	private JMenu createFilesMenu() {
        JMenu menu = new JMenu("Files");
        
        final JMenuItem FILES_LOAD = new JMenuItem("Load file");
        FILES_LOAD.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(myCanvas);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					BufferedImage img = null;
					try {
						img = ImageIO.read(new File(chooser.getSelectedFile().getAbsolutePath()));
						myCanvas.changeTurtle(img);
					} catch (IOException e1) {
					}
				}           
            }
        });
        
        final JMenuItem FILES_EXIT = new JMenuItem("EXIT");
        FILES_EXIT.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(FILES_EXIT, "Exit-->booyah!");
            }
        });
        
        return menu;
    }

    protected void initUI() {
        JFrame frame = new JFrame(MenuView.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MenuView(myView).initUI();
            }
        });
    }
    

}
