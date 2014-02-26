package backend.command;

import java.util.HashMap;

import backend.command.math.SumCommand;
import backend.command.turtle.ForwardCommand;

public class BuiltInCommands {
	private HashMap<String, Command> commands;
	public BuiltInCommands(){
		commands = new HashMap<String, Command>();
		commands.put("FOWARD", new ForwardCommand());
		commands.put("FD", new ForwardCommand());
		commands.put("SUM", new SumCommand());
	}
	
	public boolean hasCommand(String token){
		return commands.containsKey(token);
	}
	
	public Command getCommand(String token){
		return commands.get(token);
	}
}
