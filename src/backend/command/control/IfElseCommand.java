package backend.command.control;

import backend.command.Command;
import backend.command.Parameter;

public class IfElseCommand extends Command{
	protected final int myArgumentCount = 3;
	protected int currentParameters;
	protected Parameter[] myParameters;

	public IfElseCommand(){
		myParameters = new Parameter[3];
		currentParameters =0;
	}
	
	public void addArgumentDouble(Double d){
		myParameters[currentParameters] = new Parameter(d);
		currentParameters++;
	}

	public void addArgumentCommand(Command c){
		myParameters[currentParameters] = new Parameter(c);
		currentParameters++;
	}
	
	public int getArgumentCount(){
		return myArgumentCount;
	}

	public void setRepCount(int i){
		super.setRepCount(i);
		for(Parameter p: myParameters){
			p.setRepCount(i);
		}
	}
	
	@Override
	public double execute() {
		if(myParameters[0].execute() != 0)
			return myParameters[1].execute();
		else 
			return myParameters[2].execute();
	}
}
