package slogo;

import java.util.HashMap;
import java.util.Map;

import frontend.Canvas;
import frontend.Turtle;
import frontend.TurtleManager;

public class Workspace {

	private Map<Integer, Turtle> myTurtles;
	private TurtleManager myTurtleManager;
	private Canvas myCanvas;
	
	public Workspace() {
		myTurtles = new HashMap<Integer, Turtle>();
	}
	
	public Turtle getTurtle(int id) {
		if (myTurtles.containsKey(id))
			return myTurtles.get(id);
		return null;
	}

}
