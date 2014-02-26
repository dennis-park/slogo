package backend.command.control;

import backend.command.Command;
import backend.command.Parameter;

public class IfElseCommand extends Command {
	protected final int myArgumentCount = 3;
	protected int currentParameters;
	protected Parameter[] myParameters;
	
	@Override
	public void addArgumentDouble(Double d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addArgumentCommand(Command c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Command initialize() {
		// TODO Auto-generated method stub
		return null;
	}

}
