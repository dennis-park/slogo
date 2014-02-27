package backend.command;

import java.util.HashMap;

public class CommandFactory {
	private HashMap<String, String> commands;
	//Need some sort of xml or whatever data form parser to take in data in this format.
	public CommandFactory(){
		commands = new HashMap<String, String>();
		commands.put("FORWARD", "backend.command.turtle.ForwardCommand");
		commands.put("FD", "backend.command.turtle.ForwardCommand");
		commands.put("SUM", "backend.command.math.SumCommand");
	}
	
	public boolean hasCommand(String token){
		return commands.containsKey(token);
	}
	
	public Command getCommand(String token) throws InstantiationException, IllegalAccessException{
		try {
			Class c = Class.forName(commands.get(token));
			Command newCommand = (Command) c.newInstance();
			return newCommand;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
