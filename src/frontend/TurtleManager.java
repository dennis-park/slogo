package frontend;

import java.util.HashMap;
import java.util.Map;

import slogo.Commandable;
import slogo.Workspace;

public class TurtleManager {
	private Map<Integer, Turtle> myTurtleMap;
	
	public TurtleManager() {
		myTurtleMap = new HashMap<Integer, Turtle>();
		
	}
	
	public void addTurtle (Turtle t) {
		myTurtleMap.put(t.getID(), t);
	}
	
	public void move(int offset) {
		for (Turtle t : myTurtleMap.values()) {
			if(t.isActive())
				t.move(offset);
		}
	}
	
	public Workspace getWorkspace() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void 
	
	public class RotateCommand implements Commandable{
		
		@Override
		public double move() throws Exception {
			return 0;
		}

		@Override
		public double execute(int turtleID) throws Exception {
			Workspace workspace = getWorkspace();
			workspace.getTurtle(turtleID);
			return 0;
		}
	}
}
