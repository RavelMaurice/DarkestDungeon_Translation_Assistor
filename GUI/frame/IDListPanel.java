package frame;

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

	public IDListPanel() {
		// Add Components
		idList = new ScrollableList<>(DTAText.get("entry_id"));
		idList.addListSelectionListener(e -> valueChanged());
		add(idList);
	}

	public void initialize(Localization localization) {
		idList.setListData(localization.getStandardLanguage().getIDList());
		idList.setSelectedIndex(0);
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
