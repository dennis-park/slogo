package backend.command;

public class Command {//A zero parameter class
	protected int myArgumentCount;
	public Command(){
		myArgumentCount =0;
	}
	
	public void addArgumentDouble(Double d) {
		//Do nothing, no arguments
	}
	
	public void addArgumentCommand(Command c) {
		//Do nothing, no arguments
	}
	
	public double execute() {
		return 0; //Override
	}
	
	public Command initialize() {
		return null; //override or will not be needed
	}
	
	public int getArgumentCount(){
		return myArgumentCount;
	}
}
