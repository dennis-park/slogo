package backend.command.turtle;

import backend.command.Command;

public class TurnRightCommand extends Command {
	private final static int myParameterCount = 1;
	
	public TurnRightCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute() {
		double myFinalArgument = myParameters.get(0).execute();
//		Turtle.turnRight(myFinalArgument);
//		return myFinalArgument;
		
		//for now:
		return myFinalArgument;
	}
	
	public boolean equals(Object o) { //Code for testing purposes, 
		if (o instanceof TurnRightCommand){
			TurnRightCommand r = (TurnRightCommand) o;
			return (myParameters.get(0).equals(r.myParameters.get(0)));
		}
		else
			return false;
	}
	
}
