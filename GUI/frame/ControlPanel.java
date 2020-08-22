package frame;

import common.DTAButton;
import common.DTAPanel;
import main.DTAText;

@SuppressWarnings("serial")
public class ControlPanel extends DTAPanel {
	// Associations
	private IDListPanel idListPanel = null;

	// Components
	private DTAButton btnPrevious = null;
	private DTAButton btnNext = null;

	public ControlPanel() {

		// Add Components
		this.btnPrevious = new DTAButton(DTAText.get("previous"));
		this.btnPrevious.addActionListener(e -> previous());
		this.add(btnPrevious);

		this.btnNext = new DTAButton(DTAText.get("next"));
		this.btnNext.addActionListener(e -> next());
		this.add(btnNext);
	}

	private void previous() {
		this.idListPanel.previousValue();
	}

	private void next() {
		this.idListPanel.nextValue();
	}

	public void setAssociations(IDListPanel idListPanel) {
		this.idListPanel = idListPanel;
	}

}
