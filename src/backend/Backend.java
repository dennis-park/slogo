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
		checkTurtlesExist(activeTurtles);
		double returnVal = 0.0;
		for(int Id : activeTurtles) {
			returnVal = myExecutor.executeCommands(myParser.parse
					(myTokenizer.tokenize(command), myLanguage));
		}
		return returnVal;
		
		//return new LinkedList<String>(); 
		//May need to make a command class. Will have to figure out api with turtle. All this api stuff
	}
	
	public void setActiveTurtles(List<Integer> activeTurtles) {
		
	}

	public void checkTurtlesExist(List<Integer> activeTurtles) {
		List<Integer> allTurtles = myController.getAllTurtleIds();
		for(int id : activeTurtles) {
			if(!allTurtles.contains(id)) {
				myController.addTurtle(id);
				System.out.println("creating a new turtle with ID " + id);
			}
		}
	}
	
}
