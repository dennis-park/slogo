package backend.command.control;
import backend.command.Command;
import backend.command.Parameter;
public class ToCommand extends Command{
	private static final int myParameterCount = 2; //Takes in string immedaietly during parsing
	private String commandName;
	public ToCommand(){
		super(myParameterCount);
	}
	
	public void setName(String name){
		commandName = name;
	}
	
	public void addArgumentCommand(Command c){
		myParameters.add(new Parameter(c));
		currentParameters++;
		if(currentParameters == myParameterCount){
			execute();
		}
	}
	
	public double execute(){
		UserDefinedCommand newCommand = new UserDefinedCommand(commandName, myParameters.get(0).getCommand(), myParameters.get(1).getCommand());
		userCommands.put(commandName, newCommand);
		return 1.0;
		//Might need some errorchecking here for illdefined commands?
	}	
	
	
	
}
