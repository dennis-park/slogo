package slogo;

import frontend.View;
import backend.Backend;

public class Controller {
	
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
		myView.getCanvas().move(amount, id);
	}
	
	public void rotate(double angle, int id) {
		myView.getCanvas().rotate(angle, id);
	}
	
	public void setHeading(double angle, int id){
		myView.getCanvas().setHeading(angle, id);
	}
	
	public void setXY(double x, double y, int id){
		
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
