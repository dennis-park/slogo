package backend.command.display;

import backend.command.Command1Parameter;

public class SetShapeCommand extends Command1Parameter {
	public double execute(){
		//Call to controller to get shape index
		//call to controller to change shape of turtle to color index[myArgument/myParameter]
		return myArgument.execute();
	}
}
