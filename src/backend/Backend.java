package backend;

import java.util.HashMap;
import java.util.List;

import slogo.Controller;

/**
 * API to the back end, accessible by the Controller (front end-back end API) 
 * when there is a string of user input to be compiled
 */
public class Backend {
	private Tokenizer myTokenizer;
	private Parser myParser;
	private Executor myExecutor;
	private String myLanguage = "english"; //default is English
	private HashMap<String, Double> variables;
	
	public Backend(Controller c) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		variables = new HashMap<String, Double>();
		myTokenizer = new Tokenizer();
		myParser = new Parser(variables);
		myExecutor = new Executor();

	}
	
	/**
	 * Takes in a string of commands and sends the string off to the parser.
	 * This method must be called after the method that sets the language.
	 * @param command, a String of commands entered by the user
	 * @return a double...not sure what the double actually is though.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public double parse(String command) throws InstantiationException, IllegalAccessException{ 
		//Will probably need to change for error checking returns
		return myExecutor.executeCommands(myParser.parse(myTokenizer.tokenize(command), myLanguage));
		
		//return new LinkedList<String>(); 
		//May need to make a command class. Will have to figure out api with turtle. All this api stuff
	}

	public void commandActiveTurtles(List<Integer> activeTurtles) {
		for(int turtle: activeTurtles) {
//			if() {
//				
//			}
 		}
	}

}
