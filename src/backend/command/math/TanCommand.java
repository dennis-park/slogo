package backend.command.math;

import backend.command.Command1Parameter;

public class TanCommand extends Command1Parameter {
	
	@Override
	public double execute() {
		return Math.tan(myArgument.execute() * Math.PI / 180);
	}

}
