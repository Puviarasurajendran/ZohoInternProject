package xmlparse;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParseXmlTask {

	
	public void parseXMLFile() {
		
		try {
		
		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder= factory.newDocumentBuilder();
		
		Document doc=builder.parse(new File("/home/admin/Documents/EmployeeRecords.xml"));
		
		Element rootElement = doc.getDocumentElement();
		
		System.out.println("Root Element :"+ rootElement.getNodeName());
		
	       NodeList nodeList = rootElement.getChildNodes();

           for (int i = 0; i < nodeList.getLength(); i++) {
        	   
               if (nodeList.item(i) instanceof Element) { 	   
                   Element element = (Element) nodeList.item(i);
                   System.out.println(element.getTagName()+ ": " + element.getTextContent());
               }
           }
           
		
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		DomParseXmlTask dpt= new DomParseXmlTask();
		
		dpt.parseXMLFile();
		
	}
	
	
}
