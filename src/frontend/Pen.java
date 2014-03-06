package frontend;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Pen {
	
	private List<Coords> myPath = new ArrayList<Coords>();
	
	public Pen(Turtle t) {
		myPath.add(new Coords(t.getX(), t.getY()));
	}
	
	public void addTurtleCoords(double x, double y) {
		myPath.add(new Coords(x,y));
	}
	
	public void paint(Graphics g) {
		if(myPath.size() > 1){
			for(int i = 1; i < myPath.size(); i++){
				g.drawLine((int)myPath.get(i).getX(), (int)myPath.get(i).getY(), (int)myPath.get(i-1).getX(), (int)myPath.get(i-1).getY());
			}
		}
	}

}
