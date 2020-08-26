package frame;

import java.awt.GridLayout;

import common.DTAPanel;
import file.Localization;

@SuppressWarnings("serial")
public class TextContentPanel extends DTAPanel {
	// Components
	private TextContentArea area_0 = null;
	private TextContentArea area_1 = null;

	public TextContentPanel() {
		// Set Attributes
		setLayout(new GridLayout(2, 1));

		// Add Components
		area_0 = new TextContentArea(0);
		add(area_0);

		area_1 = new TextContentArea(1);
		add(area_1);
	}

	public void initialize(Localization localization) {
		area_0.initialize(localization);
		area_1.initialize(localization);
	}

	public void setTextContent(int index) {
		area_0.setTextContent(index);
		area_1.setTextContent(index);
	}

	public void saveTextContent() {
		area_1.saveTextContent();
		area_0.saveTextContent();
	}

}
