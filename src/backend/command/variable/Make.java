package backend.command.variable;

import backend.command.Command2Parameter;

public class Make extends Command2Parameter{

	public Make(){
	}
	
	public double execute(){
		return myParameters[0].getCommand().setValue(myParameters[1].execute());
	}
}
