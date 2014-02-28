package backend.command.booleanops;

import backend.command.Command2Parameter;

public class NotEqualCommand extends Command2Parameter {
	
	@Override
	public double execute() {
		return (myParameters[0].execute().equals(myParameters[1].execute())) ? 0 : 1;
	}

}
