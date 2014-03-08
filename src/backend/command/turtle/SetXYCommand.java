package backend.command.turtle;

import backend.command.Command;

public class SetXYCommand extends Command {
	
	@Override
	public double execute() {
		double newX = myParameters.get(0).execute();
		double newY = myParameters.get(1).execute();
		double dist = calculateDistance(myController.getX(myTurtleID), 0, myController.getY(myTurtleID), 0);
		myController.setXY(newX, newY, myTurtleID);
		return dist;
	}

}
