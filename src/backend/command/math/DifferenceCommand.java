package backend.command.math;

import backend.command.Command2Parameter;

public class DifferenceCommand extends Command2Parameter {
	
	@Override
	public double execute(){
		if(currentParameters != myArgumentCount)
			return 0;//error
		return myParameters[0].execute() - myParameters[1].execute();
	}
	
}
