package backend.command.control;

import backend.command.Command2Parameter;

public class ForCommand extends Command2Parameter {
	public double execute(){
		double start = myParameters[0].getCommand().get(1).execute();
		double end = myParameters[0].getCommand().get(2).execute();
		double increment = myParameters[0].getCommand().get(3).execute();
		for(double i = start; i < end; i+=increment){
			myParameters[0].getCommand().get(0).getCommand().setValue(i);
			myParameters[1].execute();
		}
		return 0.0; 
	}
}
