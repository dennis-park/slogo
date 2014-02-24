package backend;

public class Lexer {

	public Lexer(){

	}

	public String trimWhiteSpace(String string){ //Removes multiple spaces and linebreaks. Make private for refactoring 
		return string.trim().replaceAll("[\\t\\n\\r]"," ").replaceAll(" +", " ");
	}

	protected String[] parse(String string){
		return trimWhiteSpace(string).split("\\s+");
	}
}
