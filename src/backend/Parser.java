package backend;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

import backend.command.CommandFactory;
import backend.command.Command;


//http://en.wikipedia.org/wiki/Parsing#Parser
//http://en.wikipedia.org/wiki/Parse_tree
public class Parser {
	private static final String NUMBER = "-?[0-9]+\\.?[0-9]*";
	private static final String WORD = "[a-zA-z_]+(\\?)?";
	private static final String OPERANDS = "[+-/%~*]";
	private CommandFactory myCommands;
	private LinkedList<String> currentTokens;
	private static final String LEFTBRACKET = "[";
	private static final String RIGHTBRACKET = "]";
	
	public Parser(){
		myCommands = new CommandFactory();
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
	
	
	public Queue<Command> parse(String[] tokens) throws InstantiationException, IllegalAccessException{
		generateQueue(tokens);
		LinkedList<Command> commands = new LinkedList<Command>();
		while(!currentTokens.isEmpty()){ //clean up this loop later, could possibly refactor with later similar loop. Look into it.
			if(Pattern.matches(WORD, currentTokens.peek()) || Pattern.matches(OPERANDS,currentTokens.peek())){
				commands.add(defineCommand(currentTokens.remove()));
			}
			else{
				//numbers
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

	private Command defineCommand(String s) throws InstantiationException, IllegalAccessException{
		Command c;
//		String commandName = currentTokens.remove();
		if(myCommands.hasCommand(s)){
			c= myCommands.getCommand(s);
			completeCommand(c);
			return c;
		}
		return null; //command not built in/defined, an error
	}

	private void completeCommand(Command c) throws InstantiationException, IllegalAccessException {
		int numArguments = c.getArgumentCount();
		int count =0;
		String token = "emptyList";
		while(((count <numArguments) || isLeftBracket(c, count)) && isNotRightBracket(token, c)){
			count++;
			token = currentTokens.remove();
			if(token != null && Pattern.matches(NUMBER, token)){
				c.addArgumentDouble(Double.parseDouble(token));
			}
			else if((token != null && Pattern.matches(WORD, token) || Pattern.matches(OPERANDS,token)) || (token.equals(LEFTBRACKET))){
				c.addArgumentCommand(defineCommand(token));
			}
			else{
				//return error, should not happen
			}
				
		}
	}

	private boolean isLeftBracket(Command c, int count) {
		return (!currentTokens.isEmpty() && currentTokens.peek().equals(LEFTBRACKET) || c.getClass().toString().endsWith("Bracket")) && count < c.getArgumentCount();
	}
	
	private boolean isNotRightBracket(String token, Command c){
		return !token.equals(RIGHTBRACKET) && !c.getClass().toString().endsWith("BracketClose");
	}
	
	
	private void generateQueue(String[] tokens){
		for(String s: tokens){
			currentTokens.add(s);
		}
	}

}
