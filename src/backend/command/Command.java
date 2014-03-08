package backend.command;

import java.util.ArrayList;
import java.util.HashMap;

import slogo.Controller;
import backend.command.control.UserDefinedCommand;

	

/**
 * The Command superclass provides a framework for the different
 * methods that can be called by the user. This superclass is to be
 * used for commands that take no parameters; subclasses of Command
 * are commands that take one or more parameters.
 */
public class Command {//A zero parameter class
	protected ArrayList<Parameter> myParameters;
	protected int myParameterCount;
	protected int repcount;
	protected Controller myController;
	protected int myTurtleID;
	protected int currentParameters; //maybe not needed
	protected HashMap<String, Double> variables;
	protected HashMap<String, UserDefinedCommand> userCommands;
	
	public Command(){
		myParameterCount = 0;
		repcount =1;
		myParameters = new ArrayList<Parameter>();
		currentParameters =0;
	}
	
	public Command(int parameterCount){
		this();
		myParameterCount = parameterCount;
	}
	
	public void setController(Controller controller) {
		myController = controller;
		for(Parameter p: myParameters){
			if(!p.isNumber())
				p.getCommand().setController(controller);
		}
	}
	
	public void setTurtleID(int ID) {
		myTurtleID = ID;
		for(Parameter p: myParameters){
			if(!p.isNumber())
				p.getCommand().setTurtleID(ID);
		}
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
		return myParameterCount;
	}
	
	public void setRepCount(int i){
		repcount = i;
		for(Parameter p: myParameters){
			p.setRepCount(i);
		}
	}
	
	public double calculateDistance(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}


	public double setValue(double execute) {
		return 0.0;
	}
	public Parameter get(int index){
		return myParameters.get(index);
	}
	
	public int getParameterSize(){
		return myParameters.size();
	}
	
	public void setVariables(HashMap<String, Double> var){
		variables = var;
	}
	
	public void setUserCommands(HashMap<String, UserDefinedCommand> userCommands2){
		userCommands = userCommands2;
	}
}
