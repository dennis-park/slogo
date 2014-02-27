package backend.command.turtle;

import backend.command.Command;

public class HideTurtleCommand extends Command {
	
	private final String NAME_1 = "HIDETURTLE";
	private final String NAME_2 = "HT";

	@Override
	public double execute() {
		//Turtle.hideTurtle();
		return 0;
	}
	
//	@Override
//	public Command initialize() {
//		return new HideTurtleCommand();
//	}
	
}
