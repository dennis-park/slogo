package backend.command.math;

import backend.command.Command2Parameter;

public class PowCommand extends Command2Parameter {
	
	@Override
	public double execute() {
		return Math.pow(myParameters[0].execute(), myParameters[1].execute());
	}

}
