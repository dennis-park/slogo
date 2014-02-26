package backend;

public class FowardCommand extends Command {
	private final String name1 = "FOWARD";
	private final String name2 = "FD";
	private final int myArgumentCount = 1;
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
		myArgument = d;
	}
	
	public void addArgumentCommand(Command c){
		myCommandArgument = c;
	}

	public double execute(){
		if(myCommandArgument != null){
			return myCommandArgument.execute();
		}
		return myArgument;
	}
	
	public boolean match(String str){
		if(str.equalsIgnoreCase(name1) || str.equalsIgnoreCase(name2)){
			return true;
		}
		return false;
	}
	
	
	public Command initialize(){
		return new FowardCommand();
	}
	
	public boolean equals(Object obj) {
        if (obj instanceof FowardCommand){
        	FowardCommand f = (FowardCommand)obj;
            return (myArgument == f.myArgument && ((myCommandArgument== null && f.myCommandArgument == null) ||myCommandArgument.equals(f.myCommandArgument)));
        }
        else
            return false;
    }
}
