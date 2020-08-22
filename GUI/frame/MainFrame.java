package frame;

import java.awt.BorderLayout;

import common.DTAFrame;
import file.Localization;

@SuppressWarnings("serial")
public class MainFrame extends DTAFrame {
	// Attributes
	private Localization localization = null;

	// Components
	private MenuBar menuBar = null;
	private IDListPanel idListPanel = null;
	private TextContentPanel textContentPanel = null;
	private ControlPanel controlPanel = null;

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

		this.textContentPanel = new TextContentPanel();
		this.add(textContentPanel, BorderLayout.CENTER);

		this.controlPanel = new ControlPanel();
		this.add(controlPanel, BorderLayout.SOUTH);

		// Set Associations
		this.menuBar.setAssociations(this);
		this.idListPanel.setAssociations(textContentPanel);
		this.controlPanel.setAssociations(idListPanel);

	}

	public void initialize(Localization loc) {
		this.localization = loc;

		this.idListPanel.initialize(localization);
		this.textContentPanel.initialize(localization);
	}
	
	public Localization getLocalization() {
		return localization;
	}

}
