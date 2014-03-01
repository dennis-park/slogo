package backend.command.booleanops;

import backend.command.Command2Parameter;

public class OrCommand extends Command2Parameter {
	
	@Override
	public double execute() {
		return ((myParameters[0].execute() != 0.0) || (myParameters[1].execute() != 0.0))
				? 1 : 0;
	}

}
