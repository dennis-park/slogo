package slogo;

import backend.Backend;
import frontend.Frontend;
import frontend.Turtle;

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
	
	public void update() {
		// turtle list
		// parse and evaluate commands
	}
	
	
	
	
	public Workspace getWorkspace() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public class MoveCommand implements Commandable{

		@Override
		public double move() throws Exception {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double execute(int turtleID) throws Exception {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
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
