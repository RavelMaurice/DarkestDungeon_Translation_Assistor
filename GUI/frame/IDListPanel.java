package frame;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;

import common.DTAPanel;
import common.ScrollableList;
import file.Localization;
import main.DTAText;

@SuppressWarnings("serial")
public class IDListPanel extends DTAPanel {
	// Associations
	private TextContentPanel textContentPanel = null;

	// Components
	private ScrollableList<String> idList = null;
	private JLabel lblEntryCount = null;

	public IDListPanel() {
		// Set Attributes
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		setPreferredSize(new Dimension(250, 800));

		// Add Components
		idList = new ScrollableList<>(DTAText.get("entry_id"));
		idList.addListSelectionListener(e -> valueChanged());
		add(idList);

		lblEntryCount = new JLabel(DTAText.get("total") + " : -" + "        ");
		add(lblEntryCount);

	}

	public void initialize(Localization localization) {
		idList.setListData(localization.getStandardLanguage().getIDList());
		idList.setSelectedIndex(0);

		lblEntryCount.setText(DTAText.get("total") + " : " + localization.getStandardLanguage().getEntryCount());
	}

	public void setAssociations(TextContentPanel textContentPanel) {
		this.textContentPanel = textContentPanel;
	}

	public void previous() {
		idList.previous();
		valueChanged();
	}

	public void next() {
		idList.next();
		valueChanged();
	}

	private void valueChanged() {
		textContentPanel.saveTextContent();
		textContentPanel.setTextContent(idList.getSelectedIndex());

	}

	public int getSelectedIndex() {
		return idList.getSelectedIndex();
	}

}
