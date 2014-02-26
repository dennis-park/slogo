package backend;

import java.util.HashMap;

public class BuiltInCommands {
	private HashMap<String, Command> commands;
	public BuiltInCommands(){
		commands = new HashMap<String, Command>();
		commands.put("FOWARD", new FowardCommand());
		commands.put("FD", new FowardCommand());
		
	}
	
	public boolean hasCommand(String token){
		return commands.containsKey(token);
	}
	
	public Command getCommand(String token){
		return commands.get(token);
	}
}
