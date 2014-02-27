package backend.command.turtle;

import backend.command.Command;

public class PenDownCommand extends Command {

	private final String NAME_1 = "PENDOWN";
	private final String NAME_2 = "PD";
	
	@Override
	public double execute() {
		//Turtle.penDown();
		return 1;
	}
	
//	@Override
//	public Command initialize() {
//		return new PenDownCommand();
//	}
	
	
}
