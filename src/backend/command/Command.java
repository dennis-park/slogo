package backend.command;

public abstract class Command {
	protected int myArgumentCount;
	
	abstract public void addArgumentDouble(Double d);
	
	abstract public void addArgumentCommand(Command c);
	
	abstract public double execute();
	
	abstract public Command initialize();
	
	public int getArgumentCount(){
		return myArgumentCount;
	}
}
