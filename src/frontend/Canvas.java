package frontend;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {

	private View myView;
	private List<Turtle> turtles = new ArrayList<Turtle>(); 
	private Turtle DEFAULT_TURTLE;
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
		DEFAULT_TURTLE = new Turtle(DEFAULT_WIDTH/2, DEFAULT_HEIGHT/2, turtles.size()+1);
		turtles.add(DEFAULT_TURTLE);
	}

	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < turtles.size(); i++){
			turtles.get(i).paint(g);
			turtles.get(i).getPen().paint(g);
		}
	} 

	public void move(double amount, int id) {
		myView.updatePosition(turtles.get(id).getX()-WIDTH_OFFSET, HEIGHT_OFFSET-turtles.get(id).getY());
	}

	public void rotate(double angle, int id) {
		myView.updateHeading(turtles.get(id).getHeading());
	}

	public void setHeading(double newHeading, int id){
		myView.updateHeading(turtles.get(id).getHeading());
	}

	public Turtle getTurtle(int id) {
		return turtles.get(id);
	}

	public void setView(View v) {
		myView = v;
	}

	public void addTurtle() {
		turtles.add(new Turtle(DEFAULT_WIDTH/2, DEFAULT_HEIGHT/2, turtles.size()+1));
		repaint();
	}

	public void clear() {
		turtles.removeAll(turtles);
		turtles.add(DEFAULT_TURTLE);
		repaint();
	}

}