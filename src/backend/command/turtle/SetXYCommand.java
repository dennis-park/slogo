package backend.command.turtle;

import backend.command.Command;

public class SetXYCommand extends Command {
	
	@Override
	public double execute() {
		double newX = myParameters.get(0).execute();
		double newY = myParameters.get(1).execute();
		//double dist = calculateDistance(Turtle.getX, newX, Turtle.getY, newY);
		//Turtle.setXY(newX, newY);
		//return dist;
		
		//for now:
		return 0;
	}

}
