package backend.command;

import java.util.HashMap;

public class CommandFactory {
	private HashMap<String, String> commands;
	//Need some sort of xml or whatever data form parser to take in data in this format.
	public CommandFactory() {
		
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
	
//turtle queries:
		commands.put("XCOR", "backend.command.queries.XCorQuery");

		commands.put("YCOR", "backend.command.queries.YCorQuery");
		
		commands.put("HEADING", "backend.command.queries.HeadingQuery");
		
		commands.put("PENDOWN?", "backend.command.queries.PenDownQuery");
		commands.put("PENDOWNP", "backend.command.queries.PenDownQuery");
		
		commands.put("SHOWING?", "backend.command.queries.ShowingQuery");
		commands.put("SHOWINGP", "backend.command.queries.ShowingQuery");
		
//math ops:
		commands.put("SUM", "backend.command.math.SumCommand");
		commands.put("+", "backend.command.math.SumCommand");
		
		commands.put("DIFFERENCE", "backend.command.math.DifferenceCommand");
		commands.put("-", "backend.command.math.DifferenceCommand");
		
		commands.put("PRODUCT", "backend.command.math.ProductCommand");
		commands.put("*", "backend.command.math.ProductCommand");
		
		commands.put("QUOTIENT", "backend.command.math.QuotientCommand");
		commands.put("/", "backend.command.math.QuotientCommand");
		
		commands.put("REMAINDER", "backend.command.math.RemainderCommand");
		commands.put("%", "backend.command.math.RemainderCommand");

		commands.put("MINUS", "backend.command.math.MinusCommand");
		commands.put("~", "backend.command.math.MinusCommand");
		
		commands.put("RANDOM", "backend.command.math.RandomCommand");
		
		commands.put("SIN", "backend.command.math.SinCommand");
		
		commands.put("COS", "backend.command.math.CosCommand");
		
		commands.put("TAN", "backend.command.math.TanCommand");
		
		commands.put("ATAN", "backend.command.math.ArcTanCommand");
		
		commands.put("LOG", "backend.command.math.LogCommand");
		
		commands.put("POW", "backend.command.math.PowCommand");
		
//boolean ops:
		commands.put("LESS?", "backend.command.booleanops.LessThanCommand");
		commands.put("LESSP", "backend.command.booleanops.LessThanCommand");
		
		commands.put("GREATER?", "backend.command.booleanops.GreaterThanCommand");
		commands.put("GREATERP", "backend.command.booleanops.GreaterThanCommand");
		
		commands.put("EQUAL?", "backend.command.booleanops.EqualCommand");
		commands.put("EQUALP", "backend.command.booleanops.EqualCommand");
		
		commands.put("NOTEQUAL?", "backend.command.booleanops.NotEqualCommand");
		commands.put("NOTEQUALP", "backend.command.booleanops.NotEqualCommand");
		
		commands.put("AND", "backend.command.booleanops.AndCommand");
		
		commands.put("OR", "backend.command.booleanops.OrCommand");
		
		commands.put("NOT", "backend.command.booleanops.NotCommand");
		
//control structs:
		commands.put("REPEAT", "backend.command.control.RepeatCommand");
		
		commands.put("IF", "backend.command.control.IfCommand");
		
		commands.put("IFELSE", "backend.command.control.IfElseCommand");
		commands.put("REPCOUNT", "backend.command.control.RepcountCommand");
		
//misc:
		commands.put("[", "backend.command.Bracket");
		commands.put("]", "backend.command.BracketClose");
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
