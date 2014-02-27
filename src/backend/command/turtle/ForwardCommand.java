package backend.command.turtle;

import backend.command.Command;
import backend.command.Command1Parameter;
import backend.command.Parameter;

/**
 * Moving the turtle forward (relative to its heading, not to the 
 * absolute orientation of the canvas)
 */
public class ForwardCommand extends Command1Parameter {
	
	private final String NAME_1 = "FORWARD";
	private final String NAME_2 = "FD";

	//	public void addArgument(String s){ might use this if I decide to change up parsing readins
	//		if(s is a number){
	//			addArgumentDouble(Double.parseDouble(s));
	//		}
	//		else
	//			
	//	}

	public double execute(){
		double myFinalArgument = myArgument.execute();
//		Turtle.moveForward(myFinalArgument);
//		return myFinalArgument;
		
		//for now:
		return myFinalArgument;
	}

	public Command initialize(){ // will be removed by reflection, so only need to implmenent until thats done
		return new ForwardCommand();
	}

	public boolean equals(Object obj) { //Code for testing purposes, 
		if (obj instanceof ForwardCommand){
			ForwardCommand f = (ForwardCommand)obj;
			return (myArgument.equals(f.myArgument));
		}
		else
			return false;
	}
}
