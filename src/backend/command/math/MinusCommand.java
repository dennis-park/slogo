package backend.command.math;

import backend.command.Command1Parameter;

public class MinusCommand extends Command1Parameter {
	
	@Override
	public double execute(){
		return -1 * myArgument.execute();
	}

}
