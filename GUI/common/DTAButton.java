package common;

import java.awt.Dimension;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class DTAButton extends JButton {

	public DTAButton(String name) {
		super(name);
		// Set Attributes
		setEnabled(false);
		setPreferredSize(new Dimension(90, 50));
	}

}
