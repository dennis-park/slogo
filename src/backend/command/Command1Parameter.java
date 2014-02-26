package backend.command;

public class Command1Parameter extends Command {
	protected final int myArgumentCount = 1; //Gotta figure out what's happening with this instance var
	
	@Override
	public void addArgumentDouble(Double d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addArgumentCommand(Command c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Command initialize() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getArgumentCount(){
		return myArgumentCount;
	}

}
