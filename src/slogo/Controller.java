package slogo;

<<<<<<< HEAD
import java.awt.Color;

import frontend.View;
=======
>>>>>>> controller
import backend.Backend;
import frontend.Frontend;
import frontend.TurtleManager;

public class Controller {
	
	private TurtleManager myTurtleManager;
	private Backend myBackend;
	private View myView;
	
	public double sendText(String s) throws InstantiationException, IllegalAccessException {
		myBackend.parse(s);
		return myBackend.parse(s);
	}

	public void instantiate(Backend be, View v) {
		myBackend = be;
		myView = v;
	}
	
	public void move(double amount, int id) {
		myView.getCanvas().getTurtle(id).move(amount);
	}
	
<<<<<<< HEAD
	public void rotate(double angle, int id) {
		myView.getCanvas().getTurtle(id).rotate(angle);
	}
=======
	public void update() {
		// turtle list
		// parse and evaluate commands
	}
	
	
	// COMMANDS TO BACKEND TO PARSE & EVAL
	     // and TO VIEW TO UPDATE (or both)
	// move
	// rotate
	// set heading
	// set xy (move turtle)
	// pen
	// show/hide
	// clear
>>>>>>> controller
	
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
	
	// frontend to backend
	// variables
	// user defined commands
	

}
