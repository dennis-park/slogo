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
    
    public void move(double amount) {
    	DEFAULT.move(amount);
    	repaint();
    }
    
    public void rotate(double angle) {
    	DEFAULT.rotate(angle);
    	repaint();
    }
}
