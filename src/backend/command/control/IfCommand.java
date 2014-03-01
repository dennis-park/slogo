package backend.command.control;

import backend.command.Command2Parameter;

public class IfCommand extends Command2Parameter{	

	public double execute(){
//		if(currentParameters != myArgumentCount) //&& !myParameters[0].isNumber() && !myParameters[1].getCommand().getClass().toString().endsWith("Bracket")
//			return 0.0;//error message
		if(myParameters[0].execute() != 0)
			return myParameters[1].execute();
		else
			return 0.0;
	}
}
