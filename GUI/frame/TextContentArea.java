package frame;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import common.DTAPanel;
import file.Localization;
import file.Localization.Language;

@SuppressWarnings("serial")
public class TextContentArea extends DTAPanel {
	// Attributes
	private int default_index = 0;
	private Localization localization = null;
	private int selectedContent = 0;

	// Components
	private JComboBox<String> cbLangs = null;
	private JTextArea contentArea = null;

	public TextContentArea(int default_index) {
		// Set Attributes
		this.default_index = default_index;

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));

		// Add Components
		this.cbLangs = new JComboBox<>(new Vector<>());
		this.cbLangs.addActionListener(e -> setTextContent(selectedContent));
		this.add(cbLangs);

		this.contentArea = new JTextArea(8, 200);

		JScrollPane pane = new JScrollPane(contentArea);
		pane.setBorder(BorderFactory.createEmptyBorder());
		this.add(pane);

	}

	public void initialize(Localization localization) {
		this.localization = localization;

		// Set Data For ComboBox
		Vector<String> langs = new Vector<>();

		for (Language lang : localization.getLanguages()) {
			langs.add(lang.getName());
		}

		this.cbLangs.setModel(new DefaultComboBoxModel<>(langs));
		this.cbLangs.setSelectedIndex(default_index);

		this.setTextContent(selectedContent);
	}

	public void setTextContent(int index) {
		String content = localization.getEntry((String) cbLangs.getSelectedItem(), index);

		this.contentArea.setText(content);
	}

	public void changeIndex(int index) {
		String content = this.contentArea.getText();
		
		this.localization.setEntry((String) cbLangs.getSelectedItem(), selectedContent, content);
		
		this.selectedContent = index;
		this.setTextContent(selectedContent);
	}

}
