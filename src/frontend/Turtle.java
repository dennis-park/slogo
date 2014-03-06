package frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class Turtle {
	// turtle id --> private int myId;
	private double myX, myY, myPrevX, myPrevY;
	private Image myImage;

	private static int DEFAULT_WIDTH = 10;
	private static int DEFAULT_HEIGHT = 10;

	private static double myHeading = 270.0;

	public Turtle(double x, double y) {
		this(x, y, myHeading);
	}

	public Turtle(double x, double y, double heading) {
		myPrevX = x;
		myPrevY = y;
		myX = x;
		myY = y;
		myHeading = heading;
	}

	public Turtle(double x, double y, double heading, Image image) {
		myPrevX = x;
		myPrevY = y;
		myX = x;
		myY = y;
		myHeading = heading;
		myImage = image;
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
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform at = g2.getTransform();
		AffineTransform rotate = AffineTransform.getRotateInstance(Math.toRadians(myHeading),myX,myY); 
		Rectangle2D r = new Rectangle2D.Double(myX, myY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		if(myImage == null){
			g2.setColor(Color.BLACK);
			g2.transform(rotate);
			g2.draw(r);
			g2.setTransform(at);
		} else {
			g2.transform(rotate);
			g2.drawImage(myImage, (int)myX, (int)myY, Color.WHITE, null);
			g2.setTransform(at);
		}
	}

}
