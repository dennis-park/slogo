package backend;

import java.util.LinkedList;
import java.util.Queue;

//Tentative class name. The api to the backend
public class Backend {
	private Tokenizer myLexer;
	private Parser myParser;
	private Executor myTranslator;
	
	public Backend(){
		myLexer = new Tokenizer();
		myParser = new Parser();
		myTranslator = new Executor();
	}
	
	public Queue parse(String string){
		myLexer.parse(string);
		return new LinkedList<String>(); //May need to make a command class. Will have to figure out api with turtle. All this api stuff
	}

}
