package backend.command.math;

import backend.command.Command1Parameter;

public class CosCommand extends Command1Parameter {
	
	@Override
	public double execute() {
		return Math.cos(myArgument.execute() * Math.PI / 180);
	}

}
