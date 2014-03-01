package backend.command.booleanops;

import backend.command.Command2Parameter;

public class EqualCommand extends Command2Parameter {
	
	@Override
	public double execute() {
		return (myParameters[0].execute().equals(myParameters[1].execute())) ? 1 : 0;
	}

}
