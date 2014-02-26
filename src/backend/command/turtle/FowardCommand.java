package backend.command.turtle;

import backend.command.Command;
import backend.command.Command1Parameter;
import backend.command.Parameter;


public class FowardCommand extends Command1Parameter {
	private final String name1 = "FOWARD";
	private final String name2 = "FD";

	public FowardCommand(){
	}

	//	public void addArgument(String s){ might use this if I decide to change up parsing readins
	//		if(s is a number){
	//			addArgumentDouble(Double.parseDouble(s));
	//		}
	//		else
	//			
	//	}

	public double execute(){
		if(!myArgument.isNumber()){
			return myArgument.getCommand().execute();
		}
		return myArgument.getValue();
	}

	public Command initialize(){ // will be removed by reflection, so only need to implmenent until thats done
		return new FowardCommand();
	}

	public boolean equals(Object obj) { //Code for testing purposes, 
		if (obj instanceof FowardCommand){
			FowardCommand f = (FowardCommand)obj;
			return (myArgument.equals(f.myArgument));
		}
		else
			return false;
	}
}
