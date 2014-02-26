package frontend;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Canvas extends JPanel {
	
	Turtle derp = new Turtle();
	
	public Canvas() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        derp.paint(g);
    } 
    
    public void moveForward(double amount) {
    	// canvas has to be aware of turtle orientation
    	repaint(derp.getX(), derp.getY(), 20, 20);
    }
    
    public void moveBackward(double amount) {
    	
    	repaint(derp.getX(), derp.getY(), 20, 20);
    }
}
