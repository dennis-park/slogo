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
		initWorkspace();
	}

	// execute commands here
	
	public void initWorkspace() {
		myTurtles = myTurtleManager.getTurtleMap();
	}
	public void update() {
        myTurtleManager.update();
    }
	
	public Turtle getTurtle(int id) {
		if (myTurtles.containsKey(id))
			return myTurtles.get(id);
		return null;
	}
	
    public Turtle getTurtle () {
        return myTurtleManager.getCurrentTurtle();
    }

    public TurtleManager getTurtleManager () {
        return myTurtleManager;
    }
    
    public void addTurtle(int id) {
        myTurtleManager.add(new Turtle(id)); // change to fit appropriate constructor
        update();
    }
	
    public void activateTurtle(int id) {
        myTurtleManager.makeActive(myTurtles.get(id));
        update();
    }
}
