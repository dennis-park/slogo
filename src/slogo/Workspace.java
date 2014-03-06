package slogo;

import java.util.HashMap;
import java.util.Map;

import frontend.Turtle;

public class Workspace {

	private Map<Integer, Turtle> myTurtles = new HashMap<Integer, Turtle>();
	
	public Turtle getTurtle(int id) {
		if (myTurtles.containsKey(id))
			return myTurtles.get(id);
		return null;
	}

}
