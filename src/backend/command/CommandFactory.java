package backend.command;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import backend.PropertiesParser;

public class CommandFactory {
	private Map<String, String> commands;
	private HashMap<String, Double> variables;
	private String myLanguage;
	
	public CommandFactory(HashMap<String, Double> var, String language) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		myLanguage = language;
		commands = new HashMap<String, String>();
		variables = var;
		PropertiesParser parser = new PropertiesParser();
		try {
			parser.read(myLanguage, commands);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean hasCommand(String token){
		return commands.containsKey(token);
	}
	
	public Command getCommand(String token) throws InstantiationException, IllegalAccessException{
		try {
			String className = "";	
			for(String key : commands.keySet()) {
				if(key.equals(token)) {
					className = commands.get(key);
					System.out.println("\nkey: " + className);
				}
			}
			Class c = Class.forName(className);
			Command newCommand = (Command) c.newInstance();
			newCommand.setVariables(variables);//maybe pass in instance of backend/controller/whatever here
			return newCommand;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
