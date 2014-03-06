package slogo;

import frontend.Turtle;

public class Actions {
	
	class Move implements Commandable {
		@Override
		public double execute(Turtle t){
			return 0;
		}
		
	}
	public class RotateCommand implements Commandable{
		@Override
		public double execute(Turtle t, double heading){
			t.rotate(heading);
			return 0;
		}
	}
}
