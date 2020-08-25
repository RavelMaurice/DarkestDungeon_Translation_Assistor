package frame;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import common.DTAPanel;
import common.DTAScrollPane;
import file.Language;
import file.Localization;

@SuppressWarnings("serial")
public class TextContentArea extends DTAPanel {
	// Attributes
	private Localization localization = null;
	private int defaultSelectedIndex = 0;
	private int selectedTextContentIndex = 0;
	private boolean enable = true;

	// Components
	private JComboBox<String> cbLangNames = null;
	private JTextArea contentArea = null;

	public TextContentArea(int defaultSelectedIndex) {
		// Set Attributes
		setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));

		this.defaultSelectedIndex = defaultSelectedIndex;

		// Add Components
		cbLangNames = new JComboBox<>(new Vector<>());
		cbLangNames.addActionListener(e -> valueChanged());
		add(cbLangNames);

		contentArea = new JTextArea(10, 200);
		add(new DTAScrollPane(contentArea));

	}

	public void initialize(Localization localization) {
		this.localization = localization;

		// Set Data For ComboBox
		Vector<String> cbData = new Vector<>();

		for (Language lang : localization.getLanguages()) {
			cbData.add(lang.getLangName());
		}
		
		cbLangNames.setModel(new DefaultComboBoxModel<>(cbData));
		
		if(cbData.size() < defaultSelectedIndex + 1) {
			cbLangNames.setEnabled(false);
			contentArea.setEnabled(false);
			enable = false;
		}else {
			cbLangNames.setEnabled(true);
			contentArea.setEnabled(true);
			enable = true;
			
			cbLangNames.setSelectedIndex(defaultSelectedIndex);

			setTextContent(0);
		}
		
	}

	

	public String getSelectedLangName() {
		return (String) cbLangNames.getSelectedItem();
	}

	public void saveTextContent() {
		
		if(!enable) {
			return;
		}
		
		if(localization == null) {
			return;
		}
		
		String textContent = contentArea.getText();
		localization.setTextContent(getSelectedLangName(), selectedTextContentIndex, textContent);
	}

	public void setTextContent(int index) {
		
		if(!enable) {
			return;
		}
		
		if(localization == null) {
			return;
		}
		
		String textContent = localization.getTextContent(getSelectedLangName(), index);
			
		contentArea.setText(textContent);
		
		selectedTextContentIndex = index;
	}

	private void valueChanged() {
		
		if(!enable) {
			return;
		}
		
		if(localization == null) {
			return;
		}
		
		String textContent = localization.getTextContent(getSelectedLangName(), selectedTextContentIndex);
		contentArea.setText(textContent);
	}

}
