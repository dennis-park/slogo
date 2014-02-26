package frontend;

import java.awt.Color;
import java.awt.Graphics;

public class Turtle {
	// turtle id --> private int myId;
	private double myX, myY;
	private double myAngle;

	private static double DEFAULT_ANGLE = 90.0;

	public Turtle(double x, double y) {
		this(x, y, DEFAULT_ANGLE);
	}
	public Turtle(double x, double y, double angle) {
		myX = x;
		myY = y;
		myAngle = angle;
	}

	public double getX() {
		return myX;
	}

	public double getY() {
		return myY;
	}

	public double getAngle() {
		return myAngle;
	}

	public void rotate(double newAngle) {
		myAngle = newAngle;
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
