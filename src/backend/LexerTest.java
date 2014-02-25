package backend;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.ByteBuffer;



import org.junit.Test;

public class LexerTest {

	private static final String FILELOCATION = "D:\\Documents\\Duke\\2014 Spring\\CS308\\slogo_team11\\src\\backend\\spiro_small.logo";


	@Test
	public void testWhiteSpaceTrim(){
		Lexer lexer = new Lexer();
		assertEquals(lexer.trimWhiteSpace("    a    a  \n  a "), "a a a");
		assertEquals(lexer.trimWhiteSpace("[ a b c d ] "), "[ a b c d ]");
	}

	@Test
	public void testTokensBasic(){
		Lexer lexer = new Lexer();
		String[] s1 = {"a", "+", "b"};
		List<String> ls1 = new ArrayList<String>(Arrays.asList(s1));
		List<String> ls2 = new ArrayList<String>(Arrays.asList(lexer.parse("a + b")));
		assertEquals(ls1, ls2);
	}
	
	@Test
	public void testTokensNegative(){
		Lexer lexer = new Lexer();
		String[] s1 = {"a", "+", "-b"};
		List<String> ls1 = new ArrayList<String>(Arrays.asList(s1));
		List<String> ls2 = new ArrayList<String>(Arrays.asList(lexer.parse("a + -b")));
		assertEquals(ls1, ls2);
	}
	
	

	@Test
	public void testTokensSpiro() throws IOException{
		Lexer lexer = new Lexer();
		String[] s1 = {"home", "repeat", "30", "[", "repeat", "20", "[", "fd", "10", "rt", "10", "]","repeat", "10", "[", "fd", "20", "rt", "100",
				"]","]"};
		List<String> ls1 = new ArrayList<String>(Arrays.asList(s1));
		List<String> ls2 = new ArrayList<String>(Arrays.asList(lexer.parse(readFile(FILELOCATION,Charset.defaultCharset()))));
		assertEquals(ls1, ls2);
	}


	static String readFile(String path, Charset encoding) 
			throws IOException 
			{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return encoding.decode(ByteBuffer.wrap(encoded)).toString();
			}


}
