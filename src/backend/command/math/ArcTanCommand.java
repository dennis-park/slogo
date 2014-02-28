package backend.command.math;

import backend.command.Command1Parameter;

public class ArcTanCommand extends Command1Parameter {
	
	@Override
	public double execute() {
		return Math.atan(myArgument.execute() * Math.PI / 180);
	}

}
