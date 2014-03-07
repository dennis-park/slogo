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
	private Controller myController;
	private List<Integer> myActiveTurtleIDs;
	private String myLanguage = "english"; //default is English
	private HashMap<String, Double> variables;
	
	public Backend(Controller controller) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		variables = new HashMap<String, Double>();
		myTokenizer = new Tokenizer();
		myParser = new Parser(variables);
		myExecutor = new Executor();
		myController = controller;
	}
	
	public void setLanguage(String language) {
		myLanguage = language;
	}
	
	public void setActiveTurtleIDs(Controller c) {
		myActiveTurtleIDs = c.getAllTurtleIds();
	}
	
	/**
	 * Takes in a string of commands and sends the string off to the parser.
	 * This method must be called after the method that sets the language.
	 * @param command, a String of commands entered by the user
	 * @return a double that applies to the last turtle affected by the command
	 * ...not sure what the double actually is though.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public double parse(String command) throws InstantiationException, IllegalAccessException{ 
		//Will probably need to change for error checking returns
		checkTurtlesExist();
		double returnVal = 0.0;
		for(int Id : myActiveTurtleIDs) {
			returnVal = myExecutor.executeCommands(myParser.parse
					(myTokenizer.tokenize(command), myLanguage), myController, Id);
		}
		return returnVal;
		//May need to make a command class. Will have to figure out api with turtle. All this api stuff
	}

	/**
	 * Checks to make sure that all turtles in the list of active turtle IDs
	 * are existing turtles (they are in the master list of turtles)
	 */
	public void checkTurtlesExist() {
		List<Integer> allTurtles = myController.getAllTurtleIds();
		for(int id : myActiveTurtleIDs) {
			if(!allTurtles.contains(id)) {
				myController.addTurtle(id);
				System.out.println("Created a new turtle with ID " + id);
			}
		}
	}
	
}
