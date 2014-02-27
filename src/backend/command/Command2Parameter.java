package backend.command;

/**
 * A subclass of Command, Command2Parameter provides a framework for
 * commands that take two parameters (i.e. setting the turtle's position).
 */
public class Command2Parameter extends Command {
	protected final int myArgumentCount = 2;
	protected int currentParameters;
	protected Parameter[] myParameters;
	
	public Command2Parameter(){
		myParameters = new Parameter[2];
		currentParameters =0;
	}
	
	public void addArgumentDouble(Double d){
		myParameters[currentParameters] = new Parameter(d);
		currentParameters++;
	}

	public void addArgumentCommand(Command c){
		myParameters[currentParameters] = new Parameter(c);
		currentParameters++;
	}
	
	public int getArgumentCount(){
		return myArgumentCount;
	}

	@Override
	public double execute() {
		// Override in subclasses
		return 0;
	}

}
