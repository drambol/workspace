package utility.file;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XmlParser {

	protected Document doc;
	protected File file;

	public XmlParser(String str) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		file = new File(System.getProperty("user.dir") + "\\src\\xml\\" + str);
		if (!file.exists())
			file = new File(System.getProperty("user.dir") + "\\src\\" + str);
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			this.doc = builder.parse(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String getNodeValue(String str) {
		String nodeValue = null;
		try{
			nodeValue = doc.getElementsByTagName(str).item(0).getTextContent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nodeValue;
	}
	
	public Node getNodeByName(String nodeName) {
		Node node = null;
		try{
			node = doc.getElementsByTagName(nodeName).item(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return node;
	}
	
	public void save() {
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
