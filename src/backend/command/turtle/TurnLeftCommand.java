package backend.command.turtle;

import backend.command.Command;

public class TurnLeftCommand extends Command {
	private final static int myParameterCount = 1;
	
	public TurnLeftCommand(){
		super(myParameterCount);
	}
	
	@Override
	public double execute() {
		double myFinalArgument = myParameters.get(0).execute();
//		Turtle.turnLeft(myFinalArgument);
//		return myFinalArgument;
		
		//for now:
		return myFinalArgument;
	}
	
	public boolean equals(Object o) { //Code for testing purposes, 
		if (o instanceof TurnLeftCommand){
			TurnLeftCommand l = (TurnLeftCommand) o;
			return (myParameters.get(0).equals(l.myParameters.get(0)));
		}
		else
			return false;
	}
	
}
