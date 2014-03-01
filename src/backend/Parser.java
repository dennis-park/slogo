package backend;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

import backend.command.CommandFactory;
import backend.command.Command;

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

	public Queue<Command> parse(String[] tokens) throws InstantiationException, IllegalAccessException{
		generateQueue(tokens);
		LinkedList<Command> commands = new LinkedList<Command>();
		while(!currentTokens.isEmpty()){ //clean up this loop later, could possibly refactor with later similar loop. Look into it.
			if(Pattern.matches(WORD, currentTokens.peek()) || Pattern.matches(OPERANDS,currentTokens.peek()))
				commands.add(defineCommand(currentTokens.remove()));
			else{
				//numbers
				//Should not be reached. error state. No commands probably
			}
		}
		return commands;
	}

	private Command defineCommand(String s) throws InstantiationException, IllegalAccessException{
		Command c;
		//		String commandName = currentTokens.remove();
		if(myCommands.hasCommand(s)){
			c= myCommands.getCommand(s);
			completeCommand(c);
			return c;
		}
		//Display error message
		return null; //command not built in/defined, an error
	}

	private void completeCommand(Command c) throws InstantiationException, IllegalAccessException {
		int numArguments = c.getArgumentCount();
		int count =0;
		String token = "emptyList";
		while(((count <numArguments) || isLeftBracket(c, count)) && isNotRightBracket(token, c)){
			count++;
			if(currentTokens.isEmpty()){
				//Display error message
			}
			else{
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
	}

	private boolean isLeftBracket(Command c, int count) {
		return (!currentTokens.isEmpty() && currentTokens.peek().equals(LEFTBRACKET) || c.getClass().toString().endsWith("Bracket")) 
				&& count < c.getArgumentCount();
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
