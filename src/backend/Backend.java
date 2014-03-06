package backend;

import slogo.Controller;

/**
 * API to the back end, accessible by the front end when there
 * is a string of user input to be compiled
 */
public class Backend {
	private Tokenizer myTokenizer;
	private Parser myParser;
	private Executor myExecutor;
	
	public Backend(Controller c) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		myTokenizer = new Tokenizer();
		myParser = new Parser();
		myExecutor = new Executor();
	}
	
	public double parse(String string) throws InstantiationException, IllegalAccessException{ //Will probably need to change for error checking returns
		return myExecutor.executeCommands(myParser.parse(myTokenizer.tokenize(string)));
		
		//return new LinkedList<String>(); //May need to make a command class. Will have to figure out api with turtle. All this api stuff
	}


}
