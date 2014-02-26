package backend;

import java.util.LinkedList;
import java.util.Queue;

//http://en.wikipedia.org/wiki/Parsing#Parser
//http://en.wikipedia.org/wiki/Parse_tree
public class Parser {
	private BuiltInCommands myCommands;
	private LinkedList<String> currentTokens;
	
	public Parser(){
		myCommands = new BuiltInCommands();
		currentTokens = new LinkedList();
	}
	
	public Queue<Command> parse(String[] tokens){
		generateQueue(tokens);
		LinkedList<Command> commands = new LinkedList<Command>();
		Loop:
			check if current token is a number or a string or a bracket
			
			if string    possibly brackets = a command? will have to think about structure of this
				call define command()
		
			if double, return error
			
			
		
		
		
		
		
		return commands;
		
	}
	
	private Command defineCommand(){
		check if string is in built in commands 
			remove item from string queue and define command with it
			if this type of command has arguments, 
				for number of arguments
					some method(possibly enum) return if this next token is interger or a command(brackets considered command, will do later - continue until you reach aclosing bracket somehow)
						Based on ^ method, call addCommand.defineCommand() if is a string
						
					else call add argument on command
		return command created
	}
	
	private void generateQueue(String[] tokens){
		for(String s: tokens){
			currentTokens.add(s);
		}
	}

}
