package backend;

import java.util.HashMap;
import java.util.List;

import backend.command.control.UserDefinedCommand;
import slogo.Controller;

/**
 * API to the back end, accessible by the Controller (front end-back end API) 
 * when there is a string of user input to be compiled
 */
public class Backend {
	private Tokenizer myTokenizer;
	private Parser myParser;
	private Executor myExecutor;
	private Controller myController;
	private String myLanguage = "english"; //default is English
	private HashMap<String, Double> variables;
	private HashMap<String, UserDefinedCommand> userCommands;
	
	public Backend(Controller controller) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		variables = new HashMap<String, Double>();
		userCommands = new HashMap<String, UserDefinedCommand>();
		myTokenizer = new Tokenizer();
		myParser = new Parser(variables, userCommands);
		myExecutor = new Executor();
		myController = controller;
	}
	
	/**
	 * Takes in a string of commands and sends the string off to the parser.
	 * This method must be called after the method that sets the language.
	 * @param command, a String of commands entered by the user
	 * @return a double...not sure what the double actually is though.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public double parse(String command, List<Integer> activeTurtleIDs) throws InstantiationException, IllegalAccessException{ 
		//Will probably need to change for error checking returns
		double returnVal = 0.0;
		for(int ID : activeTurtleIDs) {
			returnVal = myExecutor.executeCommands(myParser.parse(myTokenizer.tokenize(command), myLanguage), myController, ID);
		}
		myController.resyncActiveTurtleIDs(); //should be replaced by a method that changes the contents of the list of active turtles
											//based on user input such as when users want to stop sending commands to certain turtles
		return returnVal;
		
		//return new LinkedList<String>(); 
		//May need to make a command class. Will have to figure out api with turtle. All this api stuff
	}


}
