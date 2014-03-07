package backend.command;

import java.util.ArrayList;


/**
 * The Command superclass provides a framework for the different
 * methods that can be called by the user. This superclass is to be
 * used for commands that take no parameters; subclasses of Command
 * are commands that take one or more parameters.
 */
public class Command {//A zero parameter class
	protected ArrayList<Parameter> myParameters;
	protected int myArgumentCount;
	protected int repcount;
	protected int currentParameters; //maybe not needed
	
	public Command(){
		myArgumentCount = 0;
		repcount =1;
		myParameters = new ArrayList<Parameter>();
	}
	
	public Command(int parameterCount){
		this();
		myArgumentCount = parameterCount;
	}
	

	public void addArgumentDouble(Double d) {
		myParameters.add(new Parameter(d));
		currentParameters++;
	}
	
	public void addArgumentCommand(Command c) {
		myParameters.add(new Parameter(c));
		currentParameters++;
	}
	
	public double execute() {
		return 0; //Override
	}
	
	
	public int getArgumentCount(){
		return myArgumentCount;
	}
	
	public void setRepCount(int i){
		for(Parameter p: myParameters){
			p.setRepCount(i);
		}
	}
	
	public double calculateDistance(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}


	public double setValue(Double execute) {
		return 0.0;
	}
	public Parameter get(int index){
		return myParameters.get(index);
	}
}
