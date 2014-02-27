package backend.command.turtle;

import backend.command.Command;

public class ShowTurtleCommand extends Command {
	
	private final String NAME_1 = "SHOWTURTLE";
	private final String NAME_2 = "ST";
	
	@Override
	public double execute() {
		//Turtle.showTurtle();
		return 1;
	}
	
//	@Override
//	public Command initialize() {
//		return new ShowTurtleCommand();
//	}
	

}
