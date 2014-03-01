package backend.command.booleanops;

import backend.command.Command2Parameter;

public class LessThanCommand extends Command2Parameter {
	
	@Override
	public double execute() {
		return (myParameters[0].execute() < myParameters[1].execute()) ? 1 : 0;
	}

}
