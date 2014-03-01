package backend.command;

/**
 * A subclass of Command, Command1Parameter provides a framework for
 * commands that take one parameter (i.e. moving forward or backward).
 */
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
	
	public void setRepCount(int i){
		super.setRepCount(i);
		myArgument.setRepCount(i);
	}

	public int getArgumentCount(){
		return myArgumentCount;
	}


}
