package backend.command.turtle;

import backend.command.Command;

public class PenUpCommand extends Command {

	private final String NAME_1 = "PENUP";
	private final String NAME_2 = "PU";
	
	@Override
	public double execute() {
		//Turtle.penUp();
		return 0;
	}
	
//	@Override
//	public Command initialize() {
//		return new PenUpCommand();
//	}
	
}
