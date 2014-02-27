package backend.command.turtle;

import backend.command.Command;
import backend.command.Command1Parameter;

/**
 * Moving the turtle backward (relative to its heading, not to the 
 * absolute orientation of the canvas)
 */
public class BackCommand extends Command1Parameter {
	public BackCommand() {
	
	}

	public double execute() {
		if(!myArgument.isNumber()){
			return -1 * myArgument.getCommand().execute();
		}
		return -1 * myArgument.getValue();
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
