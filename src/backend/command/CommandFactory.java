package backend.command;

import java.util.HashMap;

public class CommandFactory {
	private HashMap<String, String> commands;
	//Need some sort of xml or whatever data form parser to take in data in this format.
	public CommandFactory(){
		commands = new HashMap<String, String>();
		
//turtle commands:
		commands.put("FORWARD", "backend.command.turtle.ForwardCommand");
		commands.put("FD", "backend.command.turtle.ForwardCommand");
		
		commands.put("BACK", "backend.command.turtle.BackCommand");
		commands.put("BK", "backend.command.turtle.BackCommand");
		
		commands.put("LEFT", "backend.command.turtle.TurnLeftCommand");
		commands.put("LT", "backend.command.turtle.TurnLeftCommand");
		
		commands.put("RIGHT", "backend.command.turtle.TurnRightCommand");
		commands.put("RT", "backend.command.turtle.TurnRightCommand");
		
		commands.put("SETHEADING", "backend.command.turtle.SetHeadingCommand");
		commands.put("SETH", "backend.command.turtle.SetHeadingCommand");
		
		commands.put("SETXY", "backend.command.turtle.SetXYCommand");
		commands.put("GOTO", "backend.command.turtle.SetXYCommand");
		
		commands.put("PENDOWN", "backend.command.turtle.PenDownCommand");
		commands.put("PD", "backend.command.turtle.PenDownCommand");
		
		commands.put("PENUP", "backend.command.turtle.PenUpCommand");
		commands.put("PU", "backend.command.turtle.PenUpCommand");
		
		commands.put("SHOWTURTLE", "backend.command.turtle.ShowTurtleCommand");
		commands.put("ST", "backend.command.turtle.ShowTurtleCommand");
		
		commands.put("HIDETURTLE", "backend.command.turtle.HideTurtleCommand");
		commands.put("HT", "backend.command.turtle.HideTurtleCommand");
		
		commands.put("HOME", "backend.command.turtle.HomeCommand");
		
		commands.put("CLEARSCREEN", "backend.command.turtle.ClearScreenCommand");
		commands.put("CS", "backend.command.turtle.ClearScreenCommand");
		
//math commands:
		commands.put("SUM", "backend.command.math.SumCommand");
		commands.put("+", "backend.command.math.SumCommand");
		
		commands.put("DIFFERENCE", "backend.command.math.DifferenceCommand");
		commands.put("-", "backend.command.math.DifferenceCommand");
		
		commands.put("PRODUCT", "backend.command.math.ProductCommand");
		commands.put("*", "backend.command.math.ProductCommand");
		
		commands.put("QUOTIENT", "backend.command.math.QuotientCommand");
		commands.put("/", "backend.command.math.QuotientCommand");
		
		
		commands.put("[", "backend.command.Bracket");
	}
	
	public boolean hasCommand(String token){
		return commands.containsKey(token);
	}
	
	public Command getCommand(String token) throws InstantiationException, IllegalAccessException{
		try {
			Class c = Class.forName(commands.get(token));
			Command newCommand = (Command) c.newInstance();
			return newCommand;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
