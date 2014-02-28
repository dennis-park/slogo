package backend.command.math;

import backend.command.Command1Parameter;

public class SinCommand extends Command1Parameter {
	
	@Override
	public double execute() {
		return Math.sin(myArgument.execute() * Math.PI / 180);
	}

}
