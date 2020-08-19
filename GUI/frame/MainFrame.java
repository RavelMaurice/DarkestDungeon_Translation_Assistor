package frame;

import java.awt.BorderLayout;
import java.io.File;

import common.DTAFrame;
import common.ScrollableList;
import file.Localization;
import main.DTAText;

@SuppressWarnings("serial")
public class MainFrame extends DTAFrame {
	// Attributes
	private Localization localization = null;

	// Components
	private MenuBar menuBar = null;
	private IDListPanel idListPanel = null;

	public MainFrame() {
		// Set Attributes
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setLayout(new BorderLayout());

		// Add Components
		this.menuBar = new MenuBar();
		this.setJMenuBar(menuBar);
		
		this.idListPanel = new IDListPanel();
		this.add(idListPanel, BorderLayout.WEST);
		
		// Set Associations
		this.menuBar.setAssociations(this);

	}

	public void initialize(Localization loc) {
		this.localization = loc;
		
		this.idListPanel.initialize(localization);
	}

}
