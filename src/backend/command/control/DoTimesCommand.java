package backend.command.control;

import backend.command.Command;

public class DoTimesCommand extends Command {
	private static final int myParameterCount = 2;
	
	public DoTimesCommand(){
		super(myParameterCount);
	}
	public double execute(){
//		myParameters[0].getCommand().get(0); //variable
//		myParameters[0].getCommand().get(1).execute(); // limit
//		myParameters[1].execute(); //Commands to be executed 
		double limit = myParameters.get(0).getCommand().get(1).execute();
		for(double i =0; i < limit; i++){
			myParameters.get(0).getCommand().get(0).getCommand().setValue(i);
			myParameters.get(1).execute();
		}
		return 0.0; //change to return final command run after refactoring
	}
}
