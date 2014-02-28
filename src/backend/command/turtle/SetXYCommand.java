package backend.command.turtle;

import backend.command.Command2Parameter;

public class SetXYCommand extends Command2Parameter {
	
	@Override
	public double execute() {
		double newX = myParameters[0].execute();
		double newY = myParameters[1].execute();
		//double dist = calculateDistance(Turtle.getX, newX, Turtle.getY, newY);
		//Turtle.setXY(newX, newY);
		//return dist;
		
		//for now:
		return 0;
	}

}
