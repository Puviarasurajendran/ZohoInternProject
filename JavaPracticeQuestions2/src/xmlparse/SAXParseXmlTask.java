package xmlparse;

import java.util.jar.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParseXmlTask extends DefaultHandler{
	
	private StringBuilder currentValue;
    private String currentElement;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        currentValue = new StringBuilder();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!currentElement.isEmpty()) {
            System.out.println(currentElement + ": " + currentValue.toString().trim());
        }
        currentElement = "";
    }
}
	
