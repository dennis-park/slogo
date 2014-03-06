package backend.command;

import java.util.Arrays;
import java.util.HashMap;

import backend.PropertiesParser;
//import backend.XMLParser;

public class CommandFactory {
	private HashMap<String, String[]> commands;
	private String myLanguage;
	
	//private HashMap<String, String> commands;
	//Need some sort of xml or whatever data form parser to take in data in this format.

//	public CommandFactory() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	public CommandFactory(String language) throws InstantiationException, IllegalAccessException, ClassNotFoundException {	

//		commands = new HashMap<String, String>();
//		XMLParser reader = new XMLParser();
//		reader.read("src\\backend\\command\\BuiltInCommands.xml", commands);
		
		myLanguage = language;
		commands = new HashMap<String, String[]>();
		PropertiesParser parser = new PropertiesParser();
		parser.read(myLanguage, commands);
	}
	
	public boolean hasCommand(String token){
		return commands.containsKey(token);
	}
	
	public Command getCommand(String token) throws InstantiationException, IllegalAccessException{
		try {
			String commandName = "";
			for(String key : commands.keySet()) {
				if(Arrays.asList(commands.get(key)).contains(token)) {
					commandName = key;
				}
			}
			Class c = Class.forName(commandName);
			Command newCommand = (Command) c.newInstance();
			return newCommand;
		} catch (ClassNotFoundException e) {
			System.out.println("This command is not in the library of commands.");
			e.printStackTrace();
		}
		return null;
	}
}
