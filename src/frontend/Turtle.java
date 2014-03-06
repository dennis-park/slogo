package frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Turtle {
	// turtle id --> private int myId;
	private double myX, myY, myPrevX, myPrevY;
	private Image myImage;

	private static int DEFAULT_WIDTH = 10;
	private static int DEFAULT_HEIGHT = 10;
	private int myID;
	
	private double myHeading;
	private static double DEFAULT_HEADING = 90.0;

	private boolean FLAG_ACTIVE;
	
	public Turtle(double x, double y) {
		this(x, y, DEFAULT_HEADING);
	}

	public Turtle(double x, double y, double heading) {
		myPrevX = x;
		myPrevY = y;
		myX = x;
		myY = y;
		myHeading = heading;
		FLAG_ACTIVE = true;
	}
	
	public Turtle(double x, double y, double heading, Image image) {
		myPrevX = x;
		myPrevY = y;
		myX = x;
		myY = y;
		myHeading = heading;
		myImage = image;
		FLAG_ACTIVE = true;
	}
	
	public boolean isActive() {
		return FLAG_ACTIVE;
	}
	
	public void toggle() {
		FLAG_ACTIVE = !FLAG_ACTIVE;
	}
	
	public int getID() {
		return myID;
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

	public void move(double amount) {
		myPrevX = myX;
		myPrevY = myY;
		myX = myX + amount * Math.cos(Math.toRadians(myHeading));
		myY = myY + amount * Math.sin(Math.toRadians(myHeading));
	}
	
	public void rotate(double newHeading) {
		System.out.println(newHeading);
		myHeading = myHeading + newHeading;
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
