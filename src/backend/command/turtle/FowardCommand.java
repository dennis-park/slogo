package backend.command.turtle;

import backend.command.Command;
import backend.command.Command1Parameter;
import backend.command.Parameter;


public class FowardCommand extends Command1Parameter {
	private final String name1 = "FOWARD";
	private final String name2 = "FD";
//	private final int myArgumentCount = 1;
	private Parameter myArgumentP;
	private double myArgument;
	private Command myCommandArgument;
	private String myName;
	
	public FowardCommand(){
		myArgument =0;
		myCommandArgument = null;
	}

	public FowardCommand(String str) {
		myName = str;
	}
	
//	public void addArgument(String s){
//		if(s is a number){
//			addArgumentDouble(Double.parseDouble(s));
//		}
//		else
//			
//	}
	
	public void addArgumentDouble(Double d){
		myArgumentP = new Parameter(d);
		//myArgument = d;
	}
	
	public void addArgumentCommand(Command c){
		myArgumentP = new Parameter(c);
		//myCommandArgument = c;
	}
	
	public double execute(){
	if(!myArgumentP.isNumber()){
		return myArgumentP.getCommand().execute();
	}
	return myArgumentP.getValue();
}

//	public double execute(){
//		if(myCommandArgument != null){
//			return myCommandArgument.execute();
//		}
//		return myArgument;
//	}
	
	public boolean match(String str){
		if(str.equalsIgnoreCase(name1) || str.equalsIgnoreCase(name2)){
			return true;
		}
		return false;
	}
	
//	public int getArgumentCount(){
//		return myArgumentCount;
//	}
	
	
	public Command initialize(){
		return new FowardCommand();
	}
	
	public boolean equals(Object obj) {
        if (obj instanceof FowardCommand){
        	FowardCommand f = (FowardCommand)obj;
        	return (myArgumentP.equals(f.myArgumentP));
          //  return (myArgument == f.myArgument && ((myCommandArgument== null && f.myCommandArgument == null) ||myCommandArgument.equals(f.myCommandArgument)));
        }
        else
            return false;
    }
}
