package backend.command.turtle;

import backend.command.Command;
import backend.command.Command1Parameter;

public class TurnLeftCommand extends Command1Parameter {

	public TurnLeftCommand() {
		
	}
	
	@Override
	public double execute() {
		if(!myArgument.isNumber()){
			return myArgument.getCommand().execute();
		}
		return 360 - myArgument.getValue();
	}
	
}
