package slogo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import frontend.Turtle;
import frontend.View;
import backend.Backend;

public class Controller {

	private Backend myBackend;
	private View myView;
	private String myLanguage = "english"; //default is English

	public double sendText(String s) throws InstantiationException, IllegalAccessException {
		myBackend.parse(s);
		return myBackend.parse(s);
	}
	
	public void instantiate(Backend be, View v) {
		myBackend = be;
		myView = v;
	}

	public void addTurtle() {
		myView.getCanvas().addTurtle();
	}
	
	public void addTurtle(int id) {
		myView.getCanvas().addTurtle(id);
	}
	
	public void move(double amount, int id) {
		myView.getCanvas().getTurtle(id).move(amount);
	}

	public void rotate(double angle, int id) {
		myView.getCanvas().getTurtle(id).rotate(angle);
	}
	
	public void setLanguage(String language) {
		//setting the language...this doesn't connect with frontend yet though
		myLanguage = language;
		myBackend.setLanguage(myLanguage);
	}
	
	public void setHeading(double angle, int id){
		myView.getCanvas().getTurtle(id).setHeading(angle);
		myView.getCanvas().repaint();
	}

	public void setXY(double x, double y, int id){
		myView.getCanvas().getTurtle(id).setXY(x, y);
	}

	public void togglePen(boolean toggle, int id){
		myView.getCanvas().getTurtle(id).getPen().toggle(toggle);
	}

	public void setPenColor(Color c, int id){
		myView.getCanvas().getTurtle(id).getPen().changeColor(c);
	}

	public void clearAll() {
		myView.getCanvas().clear();
	}
	
	/**
	 * Returns the list of all existing turtles.
	 * @return list of all turtles (NOT of the turtles' IDs)
	 */
	public List<Turtle> getAllTurtles() {
		return myView.getCanvas().getAllTurtles();
	}
	
	/**
	 * Reads the list of all turtles, and puts the IDs of those turtles
	 * into a new list of integers.
	 * @return
	 */
	public List<Integer> getAllTurtleIds() {
		List<Integer> allTurtleIds = new ArrayList<Integer>();
		List<Turtle> allTurtles = myView.getCanvas().getAllTurtles();
		for(Turtle t : allTurtles) {
			allTurtleIds.add(t.getId());
		}
		return allTurtleIds;
	}

	// frontend to backend
	// variables
	// user defined commands


}