package frontend;

import java.awt.Color;
import java.awt.Graphics;

public class Turtle {
	// turtle id --> private int myId;
	private double myX, myY;
	private double myHeading;

	private static double DEFAULT_HEADING = 90.0;

	public Turtle(double x, double y) {
		this(x, y, DEFAULT_HEADING);
	}
	public Turtle(double x, double y, double heading) {
		myX = x;
		myY = y;
		myHeading = heading;
	}

	public double getX() {
		return myX;
	}

	public double getY() {
		return myY;
	}

	public double getHeading() {
		return myHeading;
	}

	public void rotate(double newHeading) {
		myHeading = newHeading;
	}
	

	public void paint(Graphics g) {
		g.setColor(Color.RED);
        g.fillRect((int)myX,(int)myY,4,4);
        g.setColor(Color.BLACK);
        g.drawRect((int)myX,(int)myY,4,4); 	
	}
	
	public void move(double x, double y) {
		myX = x;
		myY = y;
	}
}
