package slogo;

import backend.Backend;
import frontend.Frontend;
import frontend.TurtleController;

public class Controller {
	
	private TurtleController myTurtleControl;
	private Backend myBackend;
	private Frontend myFrontend;
	
	public double sendText(String s) throws InstantiationException, IllegalAccessException {
		myBackend.parse(s);
		return myBackend.parse(s);
	}

	public void instantiate(Backend be, Frontend fe) {
		myBackend = be;
		myFrontend = fe;
	}
	
	public void update() {
		// turtle list
		// parse and evaluate commands
	}
	
	
	// backend to frontend
	// move
	// rotate
	// set heading
	// set xy (move turtle)
	// pen
	// show/hide
	// clear
	
	
	// frontend to backend
	// variables
	// user defined commands
	

}
