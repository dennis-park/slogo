package backend.command.turtle;

import backend.command.Command;
import backend.command.Command1Parameter;

public class TurnLeftCommand extends Command1Parameter {
	
	private final String NAME_1 = "LEFT";
	private final String NAME_2 = "LT";
	
	@Override
	public double execute() {
		double myFinalArgument = myArgument.execute();
//		Turtle.turnLeft(myFinalArgument);
//		return myFinalArgument;
		
		//for now:
		return myFinalArgument;
	}
	
//	public Command initialize(){ 
//	// will be removed by reflection, so only need to implmenent until thats done
//		return new TurnLeftCommand();
//	}
	
	
	
}
