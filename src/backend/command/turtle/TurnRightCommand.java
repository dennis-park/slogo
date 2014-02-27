package backend.command.turtle;

import backend.command.Command1Parameter;

public class TurnRightCommand extends Command1Parameter {

	public TurnRightCommand() {
		
	}
	
	@Override
	public double execute() {
		if(!myArgument.isNumber()){
			return myArgument.getCommand().execute();
		}
		return myArgument.getValue();
	}
	
//	public Command initialize(){ 
//	// will be removed by reflection, so only need to implmenent until thats done
//		return new TurnRightCommand();
//	}
	
	
}
