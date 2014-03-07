package frontend;

import java.util.ArrayList;
import java.util.List;

public class Line{ // implements something that it allows to be drawn
	private List<Coordinate> myTrace;

    public Line() {
        myTrace = new ArrayList<Coordinate>();
    }

    public void addLine(Coordinate line) {
        myTrace.add(line);
    }

    public void removeLine(Coordinate removeLine) {
    	myTrace.remove(removeLine);
    }
    
    public void clearLine() {
        myTrace.clear();
    }

    //not needed if we paint elsewhere
    public List<Coordinate> getLine() {
        return myTrace;
    }
}
