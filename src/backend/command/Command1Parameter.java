package backend.command;

public class Command1Parameter extends Command {
	protected final int myArgumentCount = 1; //Gotta figure out what's happening with this instance var
	protected Parameter myArgument;
	@Override
	public void addArgumentDouble(Double d){
		myArgument = new Parameter(d);
	}

	@Override
	public void addArgumentCommand(Command c){
		myArgument = new Parameter(c);
	}

	@Override
	public double execute() {
		return 0; //Override in subclasses
	}

	@Override
	public Command initialize() {
		return null; //Override in subclasses, should be removed after using reflection
	}

	public int getArgumentCount(){
		return myArgumentCount;
	}


}
