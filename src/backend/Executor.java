package backend;

import java.util.Queue;

import backend.command.Command;

//Translates the parse tree into commands for the turtle
public class Executor { //Will need to add some error checking code most likely
	public Executor(){
		
	}
	
	public boolean executeCommands(Queue<Command> commands){
		while(!commands.isEmpty()){
			commands.remove().execute();
		}
		return true;
	}
}
