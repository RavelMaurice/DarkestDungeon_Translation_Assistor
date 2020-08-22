package frame;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import common.DTAPanel;
import file.Language;
import file.Localization;

@SuppressWarnings("serial")
public class TextContentArea extends DTAPanel {
	// Attributes
	private Localization localization = null;
	private int selectedIndex = 0;

	// Components
	private JComboBox<String> cbLangs = null;
	private JTextArea contentArea = null;

	public TextContentArea() {
		// Set Attributes
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));

		// Add Components
		this.cbLangs = new JComboBox<>(new Vector<>());
		this.cbLangs.addActionListener(e -> valueChanged());
		this.add(cbLangs);

		this.contentArea = new JTextArea(8, 200);

		JScrollPane pane = new JScrollPane(contentArea);
		pane.setBorder(BorderFactory.createEmptyBorder());
		this.add(pane);

	}

	public void initialize(Localization localization) {
		this.localization = localization;

		// Set Data For ComboBox
		Vector<String> cbData = new Vector<>();

		for (Language lang : localization.getLanguages()) {
			cbData.add(lang.getLangName());
		}

		this.cbLangs.setModel(new DefaultComboBoxModel<>(cbData));
		this.cbLangs.setSelectedIndex(0);

		this.setTextContent(0);
	}

	public void setTextContent(int index) {
		// Save Old Text Content
		String oldContent = this.contentArea.getText();
		String selectedLangName = (String) cbLangs.getSelectedItem();

		this.localization.setContent(selectedLangName, selectedIndex, oldContent);

		// Set New Text Content
		String newContent = localization.getContent(selectedLangName, index);

		this.contentArea.setText(newContent);
		
		this.selectedIndex = index;
	}

	private void valueChanged() {
		String selectedLangName = (String) cbLangs.getSelectedItem();

		String content = localization.getContent(selectedLangName, selectedIndex);

		this.contentArea.setText(content);
	}


}
