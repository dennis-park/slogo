package frontend;

import backend.Backend;

public class Frontend {
	
	Turtle derp = new Turtle();
	
	public Frontend(Canvas n, Backend be){
		System.out.println("FRONTEND");
		n.move(100,100);
	}
	
	
}
