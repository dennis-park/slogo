package backend;

import java.util.Queue;

import slogo.Controller;
import backend.command.Command;

/**
 * Translates the parse tree into commands for the turtle
 */
public class Executor { //Will need to add some error checking code most likely
	
	public double executeCommands(Queue<Command> commands, Controller controller, int ID){
		double returnValue = 0.0;
		while(!commands.isEmpty()){
			Command command = commands.remove();
			command.setTurtleID(ID);
			command.setController(controller);
			return command.execute();
		}
		return returnValue;
	}
}
