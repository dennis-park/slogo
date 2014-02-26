package backend.command.math;

import backend.command.Command;
import backend.command.Command2Parameter;


public class SumCommand extends Command2Parameter{
	public SumCommand(){
		super();
	}

	
	public double execute(){
		if(currentParameters != myArgumentCount)
			return 0;//error
		return myParameters[0].execute() + myParameters[1].execute();
	}
	
	public Command initialize(){
		return new SumCommand();
	}
	
	
}
