package main;

import java.awt.Color;

import javax.swing.UIManager;

import frame.MainFrame;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// Set UI Option
		try {
			// Set LAF
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			
			// Set Component Default Color Option
			UIManager.put("List.selectionBackground", DTAColor.FOCUSING);
			UIManager.put("List.selectionForeground", Color.BLACK);
			
		} catch (Exception e) { DTAException.createReport(e); }

		// Load Global Text
		new DTAText().load();

		// Show Main Frame
		new MainFrame().setVisible(true);
	}

}
