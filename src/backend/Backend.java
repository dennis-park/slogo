package backend;

import java.util.LinkedList;
import java.util.Queue;

import frontend.Canvas;

//Tentative class name. The api to the backend
public class Backend {
	private Lexer myLexer;
	private Parser myParser;
	private Translator myTranslator;
	
	public Backend(Canvas n){
		myLexer = new Lexer();
		myParser = new Parser();
		myTranslator = new Translator();
		
		System.out.println("BACKEND");
		n.move(4, 10);
	}
	
	public Queue parse(String string){
		myLexer.parse(string);
		return new LinkedList<String>(); //May need to make a command class. Will have to figure out api with turtle
	}

	public void sendCommand(String s) {
		
	}

}
