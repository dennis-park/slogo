package backend;

public class SumCommand extends Command{
	private final String name = "SUM";
	private final int myArgumentCount = 2;
	private double myArgument1, myArgument2;
	private Command myCommand1, myCommand2;

	public SumCommand(){
		myArgument1 = Double.MIN_VALUE;
		myArgument2 = Double.MIN_VALUE;
	}

	public void addArgumentDouble(Double d){
		if(myArgument1 == Double.MIN_VALUE)
			myArgument1 = d;
		else
			myArgument2 = d;
	}

	public void addArgumentCommand(Command c){
		if(myCommand1 == null)
			myCommand1 = c;
		else
			myCommand2 = c;
	}
	
	public int getArgumentCount(){
		return myArgumentCount;
	}
	
	public double execute(){
		if(myCommand1 != null && myCommand2 != null){
			return myCommand1.execute() + myCommand2.execute();
		}
		else if(myCommand1 != null){
			return myCommand1.execute() + myArgument1;
		}
		else
			return myArgument1 + myArgument2;
	}
	
	public Command initialize(){
		return new SumCommand();
	}
	
	
}
