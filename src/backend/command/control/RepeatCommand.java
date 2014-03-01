package backend.command.control;

import backend.command.Command2Parameter;

public class RepeatCommand extends Command2Parameter{
	public double execute(){
		int repcount; 
		Double finalVal =0.0;
		for(repcount = 1; repcount <= myParameters[0].execute(); repcount ++){
			myParameters[1].setRepCount(repcount);
			finalVal = myParameters[1].execute();
		}
		return finalVal;
	}
}
