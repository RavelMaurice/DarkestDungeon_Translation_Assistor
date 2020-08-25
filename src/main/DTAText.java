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
	// Data
	private static HashMap<String, String> textMap = new HashMap<>();

	// XML Text Constants
	private static final String STR_ENTRY = "entry";
	private static final String STR_ID 	  = "id";

	public static void load() {

		try {
			
			// Read XML
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = (Document) builder.parse(DTAPath.LANG_ENGLISH_XML);

			// Get Root Element (language tag)
			Element root = doc.getDocumentElement();

			// Get NodeList (entry tag)
			NodeList entryList = root.getElementsByTagName(STR_ENTRY);

			// Put Entry Elements
			for (int i = 0; i < entryList.getLength(); i++) {
				
				Element entry = (Element) entryList.item(i);

				String id = entry.getAttribute(STR_ID);
				String text = entry.getTextContent();

				textMap.put(id, text);
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			DTAException.createReport(e);
		}

	}

	// Getter
	public static String get(String id) { return textMap.get(id); }

}
