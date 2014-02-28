package backend.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import backend.Parser;
import backend.Tokenizer;
import backend.command.Bracket;
import backend.command.BracketClose;
import backend.command.Command;
import backend.command.turtle.ForwardCommand;
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
	
	@Test
	public void testBracket1() throws InstantiationException, IllegalAccessException{
		Parser parse = new Parser();
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("[ fd 50 fd 50 ]");
		Command fd1 = new ForwardCommand();
		Command fd2 = new ForwardCommand();
		Command bc = new BracketClose();
		Command br = new Bracket();
		fd1.addArgumentDouble(50.0);
		fd2.addArgumentDouble(50.0);
		br.addArgumentCommand(fd1);
		br.addArgumentCommand(fd2);
		br.addArgumentCommand(bc);
		Bracket a = (Bracket) parse.parse(b).remove();
		assertEquals(a, br);
	}
	
	@Test
	public void testBracket2()throws InstantiationException, IllegalAccessException{
		Parser parse = new Parser();
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("[ fd 50 sum sum 10 20 30 ]");
		assertEquals(60.0, parse.parse(b).remove().execute(), 0.01);
	}
	
	@Test
	public void testBracket3() throws InstantiationException, IllegalAccessException{
		Parser parse = new Parser();
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("[ fd [ sum sum 10 20 30 ] ]");
		assertEquals(60.0, parse.parse(b).remove().execute(), 0.01);
	}
	
	@Test
	public void testBracket4() throws InstantiationException, IllegalAccessException{
		Parser parse = new Parser();
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("[ [ ] FD 50 ]");
		assertEquals(50.0, parse.parse(b).remove().execute(), 0.01);
	}
	
	@Test
	public void testBracket5() throws InstantiationException, IllegalAccessException{
		Parser parse = new Parser();
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("sum [ ST ] [ ST ]");
		assertEquals(2.0, parse.parse(b).remove().execute(), 0.01);
	}
	
	@Test
	public void testBracket6() throws InstantiationException, IllegalAccessException{
		Parser parse = new Parser();
		Tokenizer token = new Tokenizer();
		String[] b = token.tokenize("[ sum [ sum sum 10 20 30 ] [ sum sum 10 20 30 ] ]");
		Command c = parse.parse(b).remove();
		Double d = c.execute();
		assertEquals(120.0, d, 0.01);
	}


}
