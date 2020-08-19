package main;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DTAText {

	// Atrributes
	private static HashMap<String, String> textMap = new HashMap<>();

	// XML Constants
	private static final String ENTRY = "entry";
	private static final String ID = "id";

	public static void load() {

		try {
			// Read XML
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = (Document) builder.parse("lang/english.xml");

			// Get Root Element (language tag)
			Element root = doc.getDocumentElement();

			// Get NodeList (entry tag)
			NodeList nodeList = root.getElementsByTagName(ENTRY);

			// Put Elements
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element element = (Element) nodeList.item(i);

				String id = element.getAttribute(ID);
				String text = element.getTextContent();

				textMap.put(id, text);
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}

	public static String get(String id) {
		return textMap.get(id);
	}

}
