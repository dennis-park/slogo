package backend;

public class Tokenizer {

	public Tokenizer(){

	}

	public String trimWhiteSpace(String string){ //Removes multiple spaces and linebreaks. Make private for refactoring 
		return string.trim().replaceAll("[\\t\\n\\r]"," ").replaceAll(" +", " ");
	}

	public String[] tokenize(String string){
		return trimWhiteSpace(string.toUpperCase()).split("\\s+");
	}
}
