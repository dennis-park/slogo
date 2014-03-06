package backend.command.display;

import backend.command.Command1Parameter;

public class SetPenColorCommand extends Command1Parameter {
	public double execute(){
		//Call to controller to get color index
		//call to controller to change color of pen to color index[myArgument/myParameter]
		return myArgument.execute();
	}
}
