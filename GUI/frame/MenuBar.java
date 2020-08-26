package frame;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import common.DTAMenuItem;
import file.Language;
import file.Language.Entry;
import file.Localization;
import main.DTAException;
import main.DTAText;
import util.Dialog;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	// Associatons
	private MainFrame 		 mainFrame 		  = null;
	private TextContentPanel textContentPanel = null;

	// Event
	private ActionListener l = e -> invokeMethod(e.getActionCommand());

	public MenuBar() {
		// File Menu
		JMenu fileMenu = new JMenu(DTAText.get("filemenu"));

		fileMenu.add(new DTAMenuItem(DTAText.get("filemenu_open"), "open", l));
		fileMenu.add(new DTAMenuItem(DTAText.get("filemenu_save"), "save", l));
		fileMenu.add(new DTAMenuItem(DTAText.get("filemenu_exit"), "exit", l));

		add(fileMenu);

	}

	public void setAssociations(MainFrame mainFrame, TextContentPanel textContentPanel) {
		this.mainFrame 		  = mainFrame;
		this.textContentPanel = textContentPanel;
	}

	public void invokeMethod(String methodName) {
		try { getClass().getMethod(methodName).invoke(this); } 
		catch (Exception e) { DTAException.createReport(e); }
	}

	public void open() {

		JFileChooser fileChooser = new JFileChooser();

		int option = fileChooser.showOpenDialog(mainFrame);

		if (option == JFileChooser.APPROVE_OPTION) {

			File file = fileChooser.getSelectedFile();

			Localization localization = new Localization();

			String message = localization.load(file);
			
			if (message == null) { mainFrame.initialize(localization); } 
			else { Dialog.showWarningMessageDialog(mainFrame, message); }

		}

	}

	public void save() {

		this.textContentPanel.saveTextContent();

		JFileChooser fileChooser = new JFileChooser();

		int option = fileChooser.showSaveDialog(mainFrame);

		if (option == JFileChooser.APPROVE_OPTION) {

			File file = fileChooser.getSelectedFile();

			Localization localization = mainFrame.getLocalization();

			try {
				String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n";

				FileOutputStream fos = new FileOutputStream(file, false);
				OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
				BufferedWriter writer = new BufferedWriter(osw);

				writer.write(header);
				writer.write("<root>\n");

				for (Language lang : localization.getLanguages()) {

					writer.write("<language id=\"" + lang.getLangName() + "\">\n");

					for (Entry entry : lang.getEntries()) {

						writer.write("<entry id=\"" + entry.getID() + "\">" + "<![CDATA[" + entry.getTextContent() + "]]>"
								+ "</entry>\n");

					}

					writer.write("</language>\n");
				}

				writer.write("</root>");
				writer.flush();
				writer.close();

				JOptionPane.showMessageDialog(mainFrame, "Saved!");

			} catch (IOException e) {
				DTAException.createReport(e);
			}
		}

	}
	

	public void exit() {
		System.exit(0);
	}

}
