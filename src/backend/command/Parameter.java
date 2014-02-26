package backend.command;

public class Parameter {
	private double d;
	private Command c;
	private boolean isNum;
	
	public Parameter(Double param){
		isNum = true;
		d = param;
	}
	
	public Parameter(Command c){
		isNum = false;
		c = c;
	}
	
	public boolean isNumber(){
		return isNum;
	}
	
	public Double getValue(){
		return d;
	}
	
	public Command getCommand(){
		return c;
	}
}
