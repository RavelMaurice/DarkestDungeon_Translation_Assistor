package file;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import file.IntegrityIssue.IssueType;
import main.DTAException;

public class Localization {
	// Constants
	private final String STR_LANGUAGE = "language";
	private final String STR_ID = "id";
	private final String STR_ENTRY = "entry";

	// Attributes
	private Vector<Language> languages = new Vector<>();

	public void load(File file) {
		try {
			// Read File
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			Document doc = (Document) builder.parse(file);

			// Get Root Element (root tag)
			Element root = doc.getDocumentElement();

			// Get NodeList (language tag)
			NodeList langList = root.getElementsByTagName(STR_LANGUAGE);

			for (int i = 0; i < langList.getLength(); i++) {

				Element langElement = (Element) langList.item(i);

				String langName = langElement.getAttribute(STR_ID);

				this.addLanguage(langName);

				NodeList entryList = langElement.getElementsByTagName(STR_ENTRY);

				for (int j = 0; j < entryList.getLength(); j++) {

					Element entryElement = (Element) entryList.item(j);

					String id = entryElement.getAttribute(STR_ID);
					String content = entryElement.getTextContent();

					addEntry(langName, id, content);

				}

			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			DTAException.createReport(e);
		}

	}

	public void addLanguage(String langName) {
		this.languages.add(new Language(langName));
	}

	public Language getLanguage(String langName) {

		for (Language lang : languages) {
			if (lang.getLangName().equals(langName)) {
				return lang;
			}
		}

		return null;

	}

	public Vector<Language> getLanguages() {
		return languages;
	}

	public String getContent(String langName, int index) {
		Language lang = getLanguage(langName);

		return lang.getContent(index);
	}

	public void setContent(String langName, int index, String content) {
		Language lang = getLanguage(langName);

		lang.setContent(index, content);
	}

	public void addEntry(String langName, String id, String content) {
		Language lang = getLanguage(langName);
		lang.addEntry(id, content);
	}
	
	public Language getStandardLanguage() {
		return languages.get(0);
	}

	public boolean verifyIntegrity() {
		// Check Entry Missed & Finded
		Language standard = getStandardLanguage();
		
		for(Language lang : getLanguages()) {
			
			Vector<String> finded = lang.getIDList();
			
			Vector<String> missed = new Vector<>();
			
			for(String id : standard.getIDList()) {
				boolean result = finded.remove(id);
				
				if(!result) {
					missed.add(id);
				}
			}
			
			if(finded.size() > 0 || missed.size() > 0) {
			
				IntegrityIssue issue = new IntegrityIssue(IssueType.MISSED_OR_FINDED_ID);
				issue.addItem(standard);
				issue.addItem(lang);
				issue.addItem(finded);
				issue.addItem(missed);
			
				IntegrityReport.addIssue(issue);
				
			}
			
		}

		// Create Integrity Verification Report
		if(IntegrityReport.getIssueCount() == 0) {
			return true;
		}else {
			IntegrityReport.writeReport();
			IntegrityReport.flush();
			
			return false;
		}
		
	}

}
