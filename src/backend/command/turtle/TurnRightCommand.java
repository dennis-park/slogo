package backend.command.turtle;

import backend.command.Command1Parameter;

public class TurnRightCommand extends Command1Parameter {
	
	private final String NAME_1 = "RIGHT";
	private final String NAME_2 = "RT";
	
	@Override
	public double execute() {
		double myFinalArgument = myArgument.execute();
//		Turtle.turnRight(myFinalArgument);
//		return myFinalArgument;
		
		//for now:
		return myFinalArgument;
	}
	
//	public Command initialize(){ 
//	// will be removed by reflection, so only need to implmenent until thats done
//		return new TurnRightCommand();
//	}
	
	
}
