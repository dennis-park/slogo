package backend.command;

import java.util.ArrayList;


public class Bracket extends Command {
	private ArrayList<Double> values; 
	
	public Bracket(){
		super();
		values = new ArrayList<Double>();
		myParameterCount = Integer.MAX_VALUE;
	}

	@Override
	public double execute() {
		for(Parameter p : myParameters){
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
		return this.myParameters.equals(s.myParameters);
	}

}
