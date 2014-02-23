package backend;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class LexerTest {

	@Test
	public void testWhiteSpaceTrim(){
		Lexer lexer = new Lexer();
		assertEquals(lexer.trimWhiteSpace("    a    a  \n  a "), "a a a");
		assertEquals(lexer.trimWhiteSpace("[ a b c d ] "), "[ a b c d ]");
	}

}
