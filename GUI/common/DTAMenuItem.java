package common;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class DTAMenuItem extends JMenuItem{

	public DTAMenuItem(String name, String methodName, ActionListener l) {
		super(name);

		// Set Attributes
		this.setActionCommand(methodName);

		// Set Event Listener
		this.addActionListener(l);
	}

}
