package frontend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurtleManager {
	private Map<Integer, Turtle> myTurtleMap;
	
	public TurtleManager() {
		myTurtleMap = new HashMap<Integer, Turtle>();
		
	}
	
	public void update() {
		//notify that state has been changed
	}
	
	public void add(Turtle t) {
		myTurtleMap.put(t.getID(), t);
	}
	
	public void move(int offset) {
		for (Turtle t : myTurtleMap.values()) {
			if(t.isActive())
				t.move(offset);
		}
	}
	
	private void makeActive(List<Integer> IDlist) {
		
	}
	
	private Turtle myCurr;
	
	public Turtle getCurrentTurtle() {
		return myCurr;
	}
	
	private void setCurrentTurtle(Turtle curr) {
		myCurr = curr;
	}
	
	public List<Turtle> getTurtles() {
		ArrayList<Turtle> turtles = new ArrayList<Turtle>(myTurtleMap.values());
		return turtles;
	}
	
	

}
