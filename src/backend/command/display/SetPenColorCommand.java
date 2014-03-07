package backend.command.display;

import backend.command.Command;

public class SetPenColorCommand extends Command{
	private final static int myParameterCount = 1;
	
	public SetPenColorCommand(){
		super(myParameterCount);
	}
	public double execute(){
		//Call to controller to get color index
		//call to controller to change color of pen to color index[myArgument/myParameter]
		return myParameters.get(0).execute();
	}
}
