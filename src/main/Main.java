package main;

import java.awt.Color;

import javax.swing.UIManager;

import frame.MainFrame;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// Set UI Option
		try {
			
			// Color Option
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.put("List.selectionBackground", DTAColor.FOCUSING);
			UIManager.put("List.selectionForeground", Color.BLACK);
			
		} catch (Exception e) { DTAException.createReport(e); }

		// Load Text
		new DTAText().load();

		// Show Main Frame
		new MainFrame().setVisible(true);
	}

}
