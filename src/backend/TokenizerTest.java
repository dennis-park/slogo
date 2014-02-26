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

public class TokenizerTest {

	private static final String FILELOCATION = "D:\\Documents\\Duke\\2014 Spring\\CS308\\slogo_team11\\src\\backend\\spiro_small.logo";


	@Test
	public void testWhiteSpaceTrim(){
		Tokenizer Tokenizer = new Tokenizer();
		assertEquals(Tokenizer.trimWhiteSpace("    a    a  \n  a "), "a a a");
		assertEquals(Tokenizer.trimWhiteSpace("[ a b c d ] "), "[ a b c d ]");
	}

	@Test
	public void testTokensBasic(){
		Tokenizer Tokenizer = new Tokenizer();
		String[] s1 = {"a", "+", "b"};
		List<String> ls1 = new ArrayList<String>(Arrays.asList(s1));
		List<String> ls2 = new ArrayList<String>(Arrays.asList(Tokenizer.tokenize("a + b")));
		assertEquals(ls1, ls2);
	}
	
	@Test
	public void testTokensNegative(){
		Tokenizer Tokenizer = new Tokenizer();
		String[] s1 = {"a", "+", "-b"};
		List<String> ls1 = new ArrayList<String>(Arrays.asList(s1));
		List<String> ls2 = new ArrayList<String>(Arrays.asList(Tokenizer.tokenize("a + -b")));
		assertEquals(ls1, ls2);
	}
	
	

	@Test
	public void testTokensSpiro() throws IOException{
		Tokenizer tokenizer = new Tokenizer();
		String[] s1 = {"home", "repeat", "30", "[", "repeat", "20", "[", "fd", "10", "rt", "10", "]","repeat", "10", "[", "fd", "20", "rt", "100",
				"]","]"};
		List<String> ls1 = new ArrayList<String>(Arrays.asList(s1));
		List<String> ls2 = new ArrayList<String>(Arrays.asList(tokenizer.tokenize(readFile(FILELOCATION,Charset.defaultCharset()))));
		assertEquals(ls1, ls2);
	}


	static String readFile(String path, Charset encoding) 
			throws IOException 
			{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return encoding.decode(ByteBuffer.wrap(encoded)).toString();
			}


}
