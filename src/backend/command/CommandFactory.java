package backend.command;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import backend.PropertiesParser;
//import backend.XMLParser;

public class CommandFactory {
	private Map<String, String> commands;
	private String myLanguage;
	
	//private HashMap<String, String> commands;
	//Need some sort of xml or whatever data form parser to take in data in this format.

//	public CommandFactory() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	public CommandFactory(String language) throws InstantiationException, IllegalAccessException, ClassNotFoundException {	

//		commands = new HashMap<String, String>();
//		XMLParser reader = new XMLParser();
//		reader.read("src\\backend\\command\\BuiltInCommands.xml", commands);
		
		myLanguage = language;
		commands = new HashMap<String, String>();
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
			//maybe pass in instance of backend/controller/whatever here
			return newCommand;
		} catch (ClassNotFoundException e) {
			System.out.println("This command is not in the library of commands.");
			e.printStackTrace();
		}
		return null;
	}
}
