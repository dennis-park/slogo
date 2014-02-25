package backend;

import java.util.LinkedList;
import java.util.Queue;

//Tentative class name. The api to the backend
public class Backend {
	private Lexer myLexer;
	private Parser myParser;
	private Translator myTranslator;
	
	public Backend(){
		myLexer = new Lexer();
		myParser = new Parser();
		myTranslator = new Translator();
	}
	
	public Queue parse(String string){
		myLexer.parse(string);
		return new LinkedList<String>(); //May need to make a command class. Will have to figure out api with turtle. All this api stuff
	}

}
