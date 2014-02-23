package backend;
//http://en.wikipedia.org/wiki/Lexical_analysis
public class Lexer {

	public Lexer(){
		
	}
	
	public String trimWhiteSpace(String string){ //Removes multiple spaces and linebreaks. Make private for refactoring 
		return string.trim().replaceAll("[\\t\\n\\r]"," ").replaceAll(" +", " ");
	}
	
	protected void parse(String string){
		String str = trimWhiteSpace(string);
	}
}
