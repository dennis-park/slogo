package backend;

public class Command {
	protected int myArgumentCount;
	public Command(){
		
	}
	
	public Command(String str){
		
	}
	
	public void addArgumentDouble(Double d){
		
	}
	
	public void addArgumentCommand(Command c){
		
	}
	
	public double execute(){
		return 0;
	}
	
	public Command initialize(){
		return new Command();
	}
	
	public int getArgumentCount(){
		return myArgumentCount;
	}
	

}
