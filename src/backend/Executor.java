package backend;

import java.util.Queue;
import slogo.Controller;
import backend.command.Command;

//Translates the parse tree into commands for the turtle
public class Executor { //Will need to add some error checking code most likely
	
	public double executeCommands(Queue<Command> commands, Controller c, int ID){
		double returnValue = 0.0;
		while(!commands.isEmpty()) {
			Command currentCommand = commands.remove();
			currentCommand.setController(c);
			currentCommand.setTurtleID(ID);
			returnValue = currentCommand.execute();
		}
		return returnValue;
	}
}
