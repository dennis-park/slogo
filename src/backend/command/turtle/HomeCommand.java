package backend.command.turtle;

import backend.command.Command;

public class HomeCommand extends Command {
	
	private final String NAME_1 = "HOME";
	
	@Override
	public double execute() {
		//double dist = calculateDistance(Turtle.getX, 0.0, Turtle.getY, 0.0);
		//Turtle.moveTurtleToHome();
		//return dist;
		
		//for now, just returning 0:
		return 0;
	}
	
//	@Override
//	public Command initialize() {
//		return new HomeCommand();
//	}

}
