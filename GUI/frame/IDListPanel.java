package frame;

import java.util.Vector;

import common.DTAPanel;
import common.ScrollableList;
import file.Language;
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
		this.idList = new ScrollableList<>(DTAText.get("entry_id"));
		this.idList.addListSelectionListener(e -> valueChanged());
		this.add(idList);
	}

	public void initialize(Localization localization) {
		Language lang = localization.getLanguages().get(0);
		
		this.idList.setListData(lang.getIDList());
	}

	public void setAssociations(TextContentPanel textContentPanel) {
		this.textContentPanel = textContentPanel;
	}
	
	public void previousValue() {
		this.idList.previousValue();
		this.valueChanged();
	}
	
	public void nextValue() {
		this.idList.nextValue();
		this.valueChanged();
	}

	private void valueChanged() {
		this.textContentPanel.setTextContent(idList.getSelectedIndex());
	}

}
