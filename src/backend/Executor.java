package backend;

import java.util.Queue;
import backend.command.Command;

//Translates the parse tree into commands for the turtle
public class Executor { //Will need to add some error checking code most likely
	
	public double executeCommands(Queue<Command> commands){
		double returnValue = 0.0;
		while(!commands.isEmpty()){
			returnValue = commands.remove().execute();
		}
		return returnValue;
	}
}
