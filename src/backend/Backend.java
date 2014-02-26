package backend;

import java.util.LinkedList;
import java.util.Queue;

//Tentative class name. The api to the backend
public class Backend {
	private Tokenizer myLexer;
	private Parser myParser;
	private Executor myExecutor;
	
	public Backend(){
		myLexer = new Tokenizer();
		myParser = new Parser();
		myExecutor = new Executor();
	}
	
	public Boolean parse(String string){ //Will probably need to change for error checking returns
		return myExecutor.executeCommands(myParser.parse(myLexer.tokenize(string)));
		
		//return new LinkedList<String>(); //May need to make a command class. Will have to figure out api with turtle. All this api stuff
	}

}
