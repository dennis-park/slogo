package backend.command.booleanops;

import backend.command.Command1Parameter;

public class NotCommand extends Command1Parameter {

	@Override
	public double execute() {
		return ((myArgument.execute() == 0.0)) ? 1 : 0;
	}
}
