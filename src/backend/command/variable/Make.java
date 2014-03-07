package backend.command.variable;

import backend.command.Command;

public class Make extends Command{

	public Make(){
	}
	
	public double execute(){
		return myParameters.get(0).getCommand().setValue(myParameters.get(1).execute());
	}
}
