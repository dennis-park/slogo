package backend.command.turtle;

import backend.command.Command;
import backend.command.Command1Parameter;

/**
 * Moving the turtle backward (relative to its heading, not to the 
 * absolute orientation of the canvas)
 */
public class BackCommand extends Command1Parameter {
	
	private final String NAME_1 = "BACK";
	private final String NAME_2 = "BK";

	public double execute() {
		double myFinalArgument = myArgument.execute();
//		Turtle.moveBack(myFinalArgument);
//		return myFinalArgument;
		
		//for now:
		return myFinalArgument;
	}

	public Command initialize(){ // will be removed by reflection, so only need to implmenent until thats done
		return new BackCommand();
	}

//	public boolean equals(Object obj) { //Code for testing purposes, 
//		if (obj instanceof BackCommand){
//			BackCommand b = (BackCommand)obj;
//			return (myArgument.equals(b.myArgument));
//		}
//		else
//			return false;
//	}


}
