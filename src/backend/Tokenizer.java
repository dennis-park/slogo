package backend;

/**
 * Tokenizer is to be instantiated by the Backend class, and its tokenize method
 * will be called to take a string of user input and return a string array of the
 * user input with white spaces, newlines/returns/tabs, etc. trimmed.
 *
 */
public class Tokenizer {

	public String trimWhiteSpace(String string){ 
		//Removes multiple spaces and linebreaks. Make private for refactoring 
		return string.trim().replaceAll("[\\t\\n\\r]"," ").replaceAll(" +", " ");
	}

	public String[] tokenize(String command){
		return trimWhiteSpace(command.toUpperCase()).split("\\s+");
	}
}
