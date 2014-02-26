package backend;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;


//http://en.wikipedia.org/wiki/Parsing#Parser
//http://en.wikipedia.org/wiki/Parse_tree
public class Parser {
	private static final String NUMBER = "-?[0-9]+\\.?[0-9]*";
	private static final String WORD = "[a-zA-z_]+(\\?)?";
	private BuiltInCommands myCommands;
	private LinkedList<String> currentTokens;
	private static final String LEFTBRACKET = "[";
	private static final String RIGHTBRACKET = "]";
	
	public Parser(){
		myCommands = new BuiltInCommands();
		currentTokens = new LinkedList<String>();
	}
	
//Pseeudocode for parse method
//	Loop:
//	check if current token is a number or a string or a bracket
//	
//	if string    possibly brackets = a command? will have to think about structure of this
//		call define command()
//
//	if double, return error
	
	
	public Queue<Command> parse(String[] tokens){
		generateQueue(tokens);
		LinkedList<Command> commands = new LinkedList<Command>();
		while(!currentTokens.isEmpty()){ //clean up this loop later, could possibly refactor with later similar loop. Look into it.
			if(Pattern.matches(NUMBER, currentTokens.peek())){
				//Case where it is a number, should not happen in correct code. Return error however we decide upon errors
			}
			else if(Pattern.matches(WORD, currentTokens.peek())){
				commands.add(defineCommand());
			}
			else if(currentTokens.peek().equals(LEFTBRACKET)){
				//BracketCase: commands.add(defineCommandBracket?;
			}
			else{
				//Should not be reached. error state. No commands probably
			}
		}
		return commands;
	}
	
// Pseudocode for define command and complete command methods
//	check if string is in built in commands 
//	remove item from string queue and define command with it
//	if this type of command has arguments, 
//		for number of arguments
//			some method(possibly enum) return if this next token is interger or a command(brackets considered command, will do later - continue until you reach aclosing bracket somehow)
//				Based on ^ method, call addCommand.defineCommand() if is a string
//				
//			else call add argument on command
//return command created

	private Command defineCommand(){
		Command c;
		String commandName = currentTokens.remove();
		if(myCommands.hasCommand(commandName)){
			c= myCommands.getCommand(commandName).initialize();
			completeCommand(c);
			return c;
		}
		return null; //command not built in/defined, an error
	}

	private void completeCommand(Command c) {
		int numArguments = c.getArgumentCount();
		for(int i =0; i < numArguments; i++){
			if(currentTokens.peek() != null && Pattern.matches(NUMBER, currentTokens.peek())){
				c.addArgumentDouble(Double.parseDouble(currentTokens.remove()));
			}
			else if(currentTokens.peek() != null && Pattern.matches(WORD, currentTokens.peek())){
				c.addArgumentCommand(defineCommand());
			}
			else if(currentTokens.peek().equals(LEFTBRACKET)){
				//bracketcase: addcommandbracket?
			}
			else{
				//return error, should not happen
			}
				
		}
	}
	
	private void generateQueue(String[] tokens){
		for(String s: tokens){
			currentTokens.add(s);
		}
	}

}
