package slogo;

import frontend.Frontend;
import backend.Backend;

public class Controller {
	
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
