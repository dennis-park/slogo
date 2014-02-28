package backend.command.math;

import backend.command.Command1Parameter;

public class LogCommand extends Command1Parameter {
	
	@Override
	public double execute() {
		return Math.log(myArgument.execute());
	}

}
