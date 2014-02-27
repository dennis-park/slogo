package backend.command;

import java.util.ArrayList;

public class Bracket extends Command {
	private ArrayList<Parameter> commands;
	
	public Bracket(){
		
	}
	
	@Override
	public void addArgumentDouble(Double d) {
		// Should not happen. throw an error
		
	}

	@Override
	public void addArgumentCommand(Command c) {
		commands.add(new Parameter(c));
	}

	@Override
	public double execute() {
		for(Parameter p : commands){
			p.execute();
		}
		return 0;
	}

}
