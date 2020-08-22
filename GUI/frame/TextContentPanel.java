package frame;

import java.awt.GridLayout;

import common.DTAPanel;
import file.Localization;

@SuppressWarnings("serial")
public class TextContentPanel extends DTAPanel {
	// Attributes
	private Localization localization = null;

	// Components
	private TextContentArea area_1 = null;
	private TextContentArea area_2 = null;
	private TextContentArea area_3 = null;

	public TextContentPanel() {
		// Set Attributes
		this.setLayout(new GridLayout(3, 1));

		// Add Components
		this.area_1 = new TextContentArea(0);
		this.add(area_1);

		this.area_2 = new TextContentArea(1);
		this.add(area_2);

		this.area_3 = new TextContentArea(2);
		this.add(area_3);

	}

	public void initialize(Localization localization) {
		this.localization = localization;
		
		this.area_1.initialize(localization);
		this.area_2.initialize(localization);
		this.area_3.initialize(localization);
	}
	
	public void changeIndex(int index) {
		this.area_1.changeIndex(index);
		this.area_2.changeIndex(index);
		this.area_3.changeIndex(index);
	}

}
