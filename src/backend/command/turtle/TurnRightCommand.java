package backend.command.turtle;

import backend.command.Command1Parameter;

public class TurnRightCommand extends Command1Parameter {
	
	@Override
	public double execute() {
		double myFinalArgument = myArgument.execute();
//		Turtle.turnRight(myFinalArgument);
//		return myFinalArgument;
		
		//for now:
		return myFinalArgument;
	}
	
	public boolean equals(Object o) { //Code for testing purposes, 
		if (o instanceof TurnRightCommand){
			TurnRightCommand r = (TurnRightCommand) o;
			return (myArgument.equals(r.myArgument));
		}
		else
			return false;
	}
	
}
