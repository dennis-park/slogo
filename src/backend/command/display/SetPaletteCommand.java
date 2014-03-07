package backend.command.display;

import backend.command.Command;

public class SetPaletteCommand extends Command {
	private static final int myParameterCount = 4;
	
	public SetPaletteCommand(){
		super(myParameterCount);
	}
	
	public double execute(){
		myParameters.get(0); //Color index
		myParameters.get(1); //r
		myParameters.get(2); //g
		myParameters.get(3); //b
		return 0.0;
	}
}
