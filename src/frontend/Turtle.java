package frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Turtle {
	// turtle id --> private int myId;
	private double myX, myY;
	private double myAngle;
	private Image myImage;

	private static double DEFAULT_ANGLE = 90.0;
	private static int DEFAULT_WIDTH = 10;
	private static int DEFAULT_HEIGHT = 10;

	public Turtle(double x, double y) {
		this(x, y, DEFAULT_ANGLE);
	}
	
	public Turtle(double x, double y, double angle) {
		myX = x;
		myY = y;
		myAngle = angle;
	}
	
	public Turtle(double x, double y, double angle, Image image) {
		myX = x;
		myY = y;
		myAngle = angle;
		myImage = image;
	}
	
	public void move(double amount) {
		myX = myX + amount * Math.cos(Math.toRadians(myAngle));
		myY = myY + amount * Math.sin(Math.toRadians(myAngle));
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
		myAngle = myAngle + newAngle;
	}

	public void changeTurtle(Image newTurtle) {
		myImage = newTurtle;
	}
	
	public void paint(Graphics g) {
		if(myImage == null){
			g.setColor(Color.RED);
	        g.fillRect((int)myX,(int)myY,4,4);
	        g.setColor(Color.BLACK);
	        g.drawRect((int)myX,(int)myY,4,4); 	
		}
		g.drawImage(myImage, (int)myX, (int)myY, Color.WHITE, null);
	}
	
}
