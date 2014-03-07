package backend;

import java.util.Queue;

import backend.command.Command;

/**
 * Translates the parse tree into commands for the turtle by calling the execute method on 
 * every command in the queue of commands.
 * 
 */
public class Executor { //Will need to add some error checking code most likely
	public Executor(){
		
	}
	
	public double executeCommands(Queue<Command> commands){
		double returnValue = 0.0;
		while(!commands.isEmpty()){
			returnValue = commands.remove().execute();
			
		}
		return returnValue;
	}
}
