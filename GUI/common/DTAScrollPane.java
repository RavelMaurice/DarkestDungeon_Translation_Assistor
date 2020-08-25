package common;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class DTAScrollPane extends JScrollPane {
	
	public DTAScrollPane(Component c) {
		super(c);
		// Set Attributes
		setBorder(BorderFactory.createEmptyBorder());
	}

}
