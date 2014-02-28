package backend.command.turtle;

import backend.command.Command1Parameter;

public class SetHeadingCommand extends Command1Parameter {
	
	public double execute() {
		double myFinalArgument = myArgument.execute();
		//double currentHeading = Turtle.getHeading();
		//Turtle.setHeading(myFinalArgument);
		//return myFinalArgument - currentHeading;
		
		//return number of degrees changed (clockwise), NOT abs value of 
		//change in heading
		
		//for now:
		return myFinalArgument;
	}

}
