package frame;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import common.DTAMenuItem;
import file.Localization;
import main.DTAText;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	// Associatons
	private MainFrame mainFrame = null;

	// Event
	private ActionListener l = e -> invokeMethod(e.getActionCommand());

	public MenuBar() {
		// Add Menu
		JMenu fileMenu = new JMenu(DTAText.get("filemenu"));

		fileMenu.add(new DTAMenuItem(DTAText.get("filemenu_open"), "open", l));
		fileMenu.add(new DTAMenuItem(DTAText.get("filemenu_save"), "save", l));
		fileMenu.add(new DTAMenuItem(DTAText.get("filemenu_exit"), "exit", l));

		this.add(fileMenu);

	}

	public void setAssociations(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public void invokeMethod(String methodName) {
		try {
			getClass().getMethod(methodName).invoke(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {

		JFileChooser fileChooser = new JFileChooser();

		int option = fileChooser.showOpenDialog(null);

		if (option == JFileChooser.APPROVE_OPTION) {

			File file = fileChooser.getSelectedFile();

			try {

				// Read File
				DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document doc = (Document) builder.parse(file);

				// Get Root Element (root tag)
				Element root = doc.getDocumentElement();

				// Get NodeList (language tag)
				NodeList nodeList = root.getElementsByTagName("language");

				Localization loc = new Localization();

				for (int i = 0; i < nodeList.getLength(); i++) {
					Element element = (Element) nodeList.item(i);

					String name = element.getAttribute("id");

					loc.addLanguage(name);

					NodeList entryList = element.getElementsByTagName("entry");

					for (int j = 0; j < entryList.getLength(); j++) {

						Element entry = (Element) entryList.item(j);

						if (loc.isIDInitialized()) {
							loc.addEntry(name, entry.getTextContent());
						} else {
							loc.addEntry(name, entry.getTextContent(), entry.getAttribute("id"));
						}

					}

					loc.setIDInitialized(true);

				}
				
				this.mainFrame.initialize(loc);

			} catch (ParserConfigurationException | SAXException | IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void save() {

	}

	public void exit() {
		System.exit(0);
	}

}
