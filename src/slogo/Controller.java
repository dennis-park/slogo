package slogo;

import java.awt.Color;

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
		myView.getCanvas().getTurtle(id).move(amount);
		System.out.println(id + " should have moved " + amount);
	}

	public void rotate(double angle, int id) {
		myView.getCanvas().getTurtle(id).rotate(angle);
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

	// frontend to backend
	// variables
	// user defined commands


}