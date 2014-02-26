package backend;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class ParserTest {

	@Test
	public void testFoward() {
		Parser parse = new Parser();
		Command fd = new FowardCommand();
		fd.addArgumentDouble(50.0);
		String[] fd50 = {"FD","50"};
		parse.parse(fd50);
		assertEquals(parse.parse(fd50).remove(),fd);
	}

	@Test
	public void testFowardFoward() {
		Parser parse = new Parser();
		Command fd = new FowardCommand();
		Command fd1 = new FowardCommand();
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
	Command fd = new FowardCommand();
	Command fd1 = new FowardCommand();
	fd.addArgumentDouble(50.0);
	fd1.addArgumentDouble(50.0);
	testCase.add(fd);
	testCase.add(fd1);
	
	String[] fd50fd50 = {"FD","50","FD","50"};
	assertEquals(parse.parse(fd50fd50), testCase);
	}

}
