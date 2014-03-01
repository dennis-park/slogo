package backend;
import java.io.File;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document; 
import org.w3c.dom.Element; 
import org.w3c.dom.Node; 
import org.w3c.dom.NodeList;

public class XMLParser {
	public XMLParser(){
		
	}
	protected Document makeDocumentFromFile(String fileName){
		try{
			File xmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();
			Document doc = dbuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			return doc;
		}
		catch(Exception e){
			System.out.println("File Not Found");
			return null;
		}
	}
	
	public void read(String filename, Map<String, String> commands) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Document doc = this.makeDocumentFromFile(filename);
		NodeList nList = doc.getElementsByTagName("command");
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				commands.put(eElement.getAttribute("name"), eElement.getAttribute("class"));
			}
		}
	}
		
}
