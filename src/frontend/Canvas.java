package frontend;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class Canvas extends JPanel {
	
	private View myView;
	private Turtle DEFAULT = new Turtle(100, 100);
	
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
    	myView.updatePosition(DEFAULT.getX(), DEFAULT.getY());
    }
    
    public void rotate(double angle) {
    	DEFAULT.rotate(angle);
    	repaint();
    	myView.updateHeading(DEFAULT.getHeading());
    }
    
    public Turtle getTurtle() {
    	return DEFAULT;
    }
    
    public void changeTurtle(Image image){
    	DEFAULT.changeTurtle(image);
    	repaint();
    }

	public void setView(View v) {
		myView = v;
	}
}
