package frontend;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class Canvas extends JPanel {

	private View myView;
	private Turtle DEFAULT;
	private static int DEFAULT_WIDTH;
	private static int DEFAULT_HEIGHT;
	private static int WIDTH_OFFSET;
	private static int HEIGHT_OFFSET;

	public Canvas(int width, int height) {
		DEFAULT_WIDTH = width;
		DEFAULT_HEIGHT = height;
		WIDTH_OFFSET = DEFAULT_WIDTH/2;
		HEIGHT_OFFSET = DEFAULT_HEIGHT/2;
		setBorder(BorderFactory.createLineBorder(Color.black));
		DEFAULT  = new Turtle(DEFAULT_WIDTH/2, DEFAULT_HEIGHT/2);
	}

	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		DEFAULT.paint(g);
	} 

	public void move(double amount) {
		DEFAULT.move(amount);
		repaint();
		myView.updatePosition(DEFAULT.getX()-WIDTH_OFFSET, HEIGHT_OFFSET-DEFAULT.getY());
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
