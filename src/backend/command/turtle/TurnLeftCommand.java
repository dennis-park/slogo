package backend.command.turtle;

import backend.command.Command1Parameter;

public class TurnLeftCommand extends Command1Parameter {
	
	@Override
	public double execute() {
		double myFinalArgument = myArgument.execute();
//		Turtle.turnLeft(myFinalArgument);
//		return myFinalArgument;
		
		//for now:
		return myFinalArgument;
	}
	
	public boolean equals(Object o) { //Code for testing purposes, 
		if (o instanceof TurnLeftCommand){
			TurnLeftCommand l = (TurnLeftCommand) o;
			return (myArgument.equals(l.myArgument));
		}
		else
			return false;
	}
	
}
