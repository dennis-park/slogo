package backend.command.variable;

import backend.Backend;
import backend.command.Command;

public class Variable extends Command {
	private String name;
	
	public Variable(String var){
		name = var;
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
