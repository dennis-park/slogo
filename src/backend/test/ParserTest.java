package backend.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import backend.Parser;
import backend.command.Command;
import backend.command.turtle.TurnRightCommand;

public class ParserTest {

	@Test
	public void testRight() throws InstantiationException, IllegalAccessException {
		Parser parse = new Parser();
		Command rt = new TurnRightCommand();
		rt.addArgumentDouble(50.0);
		String[] rt50 = {"RT","50"};
		parse.parse(rt50);
		assertEquals(parse.parse(rt50).remove(), rt);
	}

	@Test
	public void testRightRight() throws InstantiationException, IllegalAccessException {
		Parser parse = new Parser();
		Command rt = new TurnRightCommand();
		Command rt1 = new TurnRightCommand();
		rt1.addArgumentDouble(50.0);
		rt.addArgumentCommand(rt1);
		String[] rt50 = {"RT","RT","50"};
		parse.parse(rt50);
		assertEquals(parse.parse(rt50).remove(), rt);
	}

	@Test
	public void testMultipleCommands() throws InstantiationException, IllegalAccessException{
		LinkedList<Command> testCase = new LinkedList<Command>();
		Parser parse = new Parser();
		Command rt = new TurnRightCommand();
		Command rt1 = new TurnRightCommand();
		rt.addArgumentDouble(50.0);
		rt1.addArgumentDouble(50.0);
		testCase.add(rt);
		testCase.add(rt1);

		String[] rt50rt50 = {"RT","50","RT","50"};
		assertEquals(parse.parse(rt50rt50), testCase);
	}

//	@Test
//	public void testDiffBasic() throws InstantiationException, IllegalAccessException{
//		Parser parse = new Parser();
//		String[] diff = {"-", "60", "50"};
//		assertEquals(parse.parse(diff).remove().execute(), 10.0, 0.01);
//	}
	
	@Test
	public void testProductBasic() throws InstantiationException, IllegalAccessException{
		Parser parse = new Parser();
		String[] prod = {"PRODUCT", "6", "5"};
		assertEquals(parse.parse(prod).remove().execute(), 30.0, 0.01);
	}

	@Test
	public void testSinBasic() throws InstantiationException, IllegalAccessException{
		Parser parse = new Parser();
		String[] sin = {"SIN", "90"};
		assertEquals(parse.parse(sin).remove().execute(), 1.0, 0.01);
	}
	
	@Test
	public void testEqualBasic() throws InstantiationException, IllegalAccessException{
		Parser parse = new Parser();
		String[] equals = {"EQUALP", "80", "90"};
		assertEquals(parse.parse(equals).remove().execute(), 0.0, 0.01);
	}
	
	@Test
	public void testNotBasic() throws InstantiationException, IllegalAccessException{
		Parser parse = new Parser();
		String[] not = {"NOT", "80"};
		assertEquals(parse.parse(not).remove().execute(), 0.0, 0.01);
	}
	
	@Test
	public void testAndBasic() throws InstantiationException, IllegalAccessException{
		Parser parse = new Parser();
		String[] and = {"AND", "80", "90"};
		assertEquals(parse.parse(and).remove().execute(), 1.0, 0.01);
	}
	
	@Test
	public void testAnd2Basic() throws InstantiationException, IllegalAccessException{
		Parser parse = new Parser();
		String[] and = {"AND", "80", "0"};
		assertEquals(parse.parse(and).remove().execute(), 0.0, 0.01);
	}
	
//	@Test
//	public void testSumBasic() throws InstantiationException, IllegalAccessException{
//		Parser parse = new Parser();
//		String[] sum = {"+", "60", "50"};
//		assertEquals(parse.parse(sum).remove().execute(), 110.0, 0.01);
//	}

//	@Test
//	public void testDiffNesting() throws InstantiationException, IllegalAccessException{
//		Parser parse = new Parser();
//		String[] diff = {"-", "-", "10", "-", "20", "30", "40"};
//		assertEquals(parse.parse(diff).remove().execute(), 100.0, 0.01);
//	}


}
