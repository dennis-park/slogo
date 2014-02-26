package backend.command;

import backend.command.turtle.FowardCommand;

public class Parameter {
	private double d;
	private Command c;
	private boolean isNum;

	public Parameter(Double param){
		isNum = true;
		d = param;
	}

	public Parameter(Command param){
		isNum = false;
		c = param;
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

	public boolean equals(Object obj){
		if (obj instanceof Parameter){
			Parameter p = (Parameter)obj;
			if(isNum)
				return (this.d == p.d);
			else
				return (this.c.equals(p.c));
		}
		else
			return false;
	}
}
