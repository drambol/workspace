package utility.file;


public class EnvironmentVariable {
	
	public static String getChromeLocation(){
		
		XmlParser xmlParser = new XmlParser("runSuite\\Config.xml");
		return xmlParser.getNodeValue("chrome");		
	}

}
