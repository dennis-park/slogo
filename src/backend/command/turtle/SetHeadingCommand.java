package backend.command.turtle;

import backend.command.Command;
import backend.command.Command1Parameter;

public class SetHeadingCommand extends Command1Parameter {
	
	private final String NAME_1 = "SETHEADING";
	private final String NAME_2 = "SETH";

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

	public Command initialize(){ // will be removed by reflection, so only need to implmenent until thats done
		return new SetHeadingCommand();
	}

}
