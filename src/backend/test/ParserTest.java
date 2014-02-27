package backend.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import backend.Parser;
import backend.command.Command;
import backend.command.turtle.ForwardCommand;

public class ParserTest {

	@Test
	public void testFoward() {
		Parser parse = new Parser();
		Command fd = new ForwardCommand();
		fd.addArgumentDouble(50.0);
		String[] fd50 = {"FD","50"};
		parse.parse(fd50);
		assertEquals(parse.parse(fd50).remove(),fd);
	}

	@Test
	public void testFowardFoward() {
		Parser parse = new Parser();
		Command fd = new ForwardCommand();
		Command fd1 = new ForwardCommand();
		fd1.addArgumentDouble(50.0);
		fd.addArgumentCommand(fd1);
		String[] fd50 = {"FD","FD","50"};
		parse.parse(fd50);
		assertEquals(parse.parse(fd50).remove(),fd);
	}

	@Test
	public void testMultipleCommands(){
		LinkedList<Command> testCase = new LinkedList<Command>();
		Parser parse = new Parser();
		Command fd = new ForwardCommand();
		Command fd1 = new ForwardCommand();
		fd.addArgumentDouble(50.0);
		fd1.addArgumentDouble(50.0);
		testCase.add(fd);
		testCase.add(fd1);

		String[] fd50fd50 = {"FD","50","FD","50"};
		assertEquals(parse.parse(fd50fd50), testCase);
	}

	@Test
	public void testSumBasic(){
		Parser parse = new Parser();
		String[] sum = {"SUM", "50", "50"};
		assertEquals(parse.parse(sum).remove().execute(), 100.0, 0.01);
	}

	@Test
	public void testSumNesting(){
		Parser parse = new Parser();
		String[] sum = {"SUM", "SUM", "10", "SUM", "20", "30", "40"};
		assertEquals(parse.parse(sum).remove().execute(), 100.0, 0.01);
	}


}
