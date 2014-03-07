package frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class Turtle {
	private Pen myPen;
	private int myId;
	private double myX, myY;
	private Image myImage;

	private static int DEFAULT_WIDTH = 10;
	private static int DEFAULT_HEIGHT = 10;
<<<<<<< HEAD

	private static double myHeading = 270.0;

	public Turtle(double x, double y, int id) {
		this(x, y, myHeading, id);
		myPen = new Pen(this);
	}

	public Turtle(double x, double y, double heading, int id) {
		myId = id;
		myX = x;
		myY = y;
		myHeading = heading;
		myPen = new Pen(this);
=======
	private int myID;
	
	private double myHeading;
	private static double DEFAULT_HEADING = 90.0;

	private boolean FLAG_ACTIVE;
	
	public Turtle(int id) {
		this(200,200); // loaded dummy vals for dimensions
		myID = id;
	}
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
>>>>>>> controller
	}

	public Turtle(double x, double y, double heading, Image image, int id) {
		myId = id;
		myX = x;
		myY = y;
		myHeading = heading;
		myImage = image;
<<<<<<< HEAD
		myPen = new Pen(this);
=======
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
>>>>>>> controller
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
	
	public int getId() {
		return myId;
	}
	
	public Pen getPen(){
		return myPen;
	}

	public void move(double amount) {
		myX = myX + amount * Math.cos(Math.toRadians(myHeading));
		myY = myY + amount * Math.sin(Math.toRadians(myHeading));
		myPen.addTurtleCoords(myX, myY);
	}

	public void rotate(double angle) {
		myHeading = myHeading + angle;
	}

	public void setHeading(double newHeading) {
		myHeading = newHeading;
	}
	
	public void setXY(double x, double y) {
		myX = x;
		myY =y;
	}
	
	public void togglePen(boolean toggle) {
		myPen.toggle(toggle);
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
			g2.drawString(myId+"", (int)myX, (int)myY - DEFAULT_HEIGHT);
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
