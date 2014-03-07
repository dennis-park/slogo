package backend.command.turtle;

import backend.command.Command;

public class SetHeadingCommand extends Command {
	private final static int myParameterCount = 1;
	
	public SetHeadingCommand(){
		super(myParameterCount);
	}
	
	public double execute() {
		double myFinalArgument = myParameters.get(0).execute();
		//double currentHeading = Turtle.getHeading();
		//Turtle.setHeading(myFinalArgument);
		//return myFinalArgument - currentHeading;
		
		//return number of degrees changed (clockwise), NOT abs value of 
		//change in heading
		
		//for now:
		return myFinalArgument;
	}

}
