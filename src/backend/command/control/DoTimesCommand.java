package backend.command.control;

import backend.command.Command2Parameter;

public class DoTimesCommand extends Command2Parameter {
	public double execute(){
//		myParameters[0].getCommand().get(0); //variable
//		myParameters[0].getCommand().get(1).execute(); // limit
//		myParameters[1].execute(); //Commands to be executed 
		double limit = myParameters[0].getCommand().get(1).execute();
		for(double i =0; i < limit; i++){
			myParameters[0].getCommand().get(0).getCommand().setValue(i);
			myParameters[1].execute();
		}
		return 0.0; //change to return final command run after refactoring
	}
}
