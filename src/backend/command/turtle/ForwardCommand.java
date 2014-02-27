package backend.command.turtle;

import backend.command.Command1Parameter;

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


	public boolean equals(Object obj) { //Code for testing purposes, 
		if (obj instanceof ForwardCommand){
			ForwardCommand f = (ForwardCommand)obj;
			return (myArgument.equals(f.myArgument));
		}
		else
			return false;
	}
}
