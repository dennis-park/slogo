package backend.command;


/**
 * The Command superclass provides a framework for the different
 * methods that can be called by the user. This superclass is to be
 * used for commands that take no parameters; subclasses of Command
 * are commands that take one or more parameters.
 */
public class Command {//A zero parameter class
	
	protected int myArgumentCount;
	protected int repcount;
	
	public Command(){
		myArgumentCount = 0;
		repcount =1;
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
	
	
	public int getArgumentCount(){
		return myArgumentCount;
	}
	
	public void setRepCount(int i){
		repcount = i;
	}
	
	public double calculateDistance(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}


	public double setValue(Double execute) {
		return 0.0;
		// TODO Auto-generated method stub
		//bad coding practice please fix
	}
	public Parameter get(int index){
		//return commands.get(index);
		return new Parameter(0.0); // fix when refactoring
	}
}
