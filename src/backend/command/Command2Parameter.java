package backend.command;

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

	@Override
	public Command initialize() {
		// Override in subclasses, shouldn't need to be used
		return null;
	}

}
