package frame;

import common.DTAPanel;
import common.ScrollableList;
import file.Localization;
import main.DTAText;

@SuppressWarnings("serial")
public class IDListPanel extends DTAPanel {
	// Components
	private ScrollableList<String> idList = null;
	
	public IDListPanel() {
		// Add Components
		this.idList = new ScrollableList<>(DTAText.get("entry_id"));
		this.add(idList);
	}

	public void initialize(Localization localization) {
		this.idList.setListData(localization.getEntryIDs());
	}

}
