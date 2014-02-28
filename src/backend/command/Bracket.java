package backend.command;

import java.util.ArrayList;


public class Bracket extends Command {
	private ArrayList<Parameter> commands;
	private ArrayList<Double> values; 
	
	public Bracket(){
		commands = new ArrayList<Parameter>();
		values = new ArrayList<Double>();
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
			p.setRepCount(repcount);
			values.add(p.execute());
		}
		if(values.size() < 2)
			return 0;
		else
			return values.get(values.size()-2);
	}
	
	public boolean equals(Object obj){
		Bracket s = (Bracket)obj;
		return this.commands.equals(s.commands);
	}
	
}
