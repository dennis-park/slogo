package backend.command.variable;

import backend.command.Command;
import java.util.HashMap;

public class Variable extends Command {
	private String name;
	
	public Variable(String varName, HashMap<String, Double> var){
		name = varName;
		variables = var;
		if(!variables.containsKey(name)){
			variables.put(name, 0.0);
		}
	}
	
	public double setValue(double val){
		variables.put(name, val);
		return val;
	}
	
	public double execute(){
		return variables.get(name);
	}
}
