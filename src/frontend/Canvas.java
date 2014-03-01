package frontend;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Canvas extends JPanel {
	
	public Turtle DEFAULT = new Turtle(100, 100);
	
	public Canvas() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        DEFAULT.paint(g);
    } 
    
    public void moveForward(double amount) {
    	// canvas has to be aware of turtle orientation
    	System.out.println("I, THE CANVAS HAVE BEEN ORDERED TO MOVE THE TURTLE FORWARD");
    	DEFAULT.moveFoward(amount);
    	repaint((int)DEFAULT.getX(), (int)DEFAULT.getY(), 20, 20);
    }
    
    public void moveBackward(double amount) {
    	repaint((int)DEFAULT.getX(), (int)DEFAULT.getY(), 20, 20);
    }
}
