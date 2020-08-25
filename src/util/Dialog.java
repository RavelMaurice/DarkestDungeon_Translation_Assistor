package util;

import java.awt.Component;

import javax.swing.JOptionPane;

import main.DTAText;

@SuppressWarnings("serial")
public final class Dialog extends JOptionPane {

	public static final void showWarningMessageDialog(Component parentComponent, String message) {

		String title = DTAText.get("dialog_warning_title");

		showMessageDialog(parentComponent, message, title, WARNING_MESSAGE);
	}
	
	public static final void showErrorMessageDialog(Component parentComponent, String message) {

		String title = DTAText.get("dialog_error_title");

		showMessageDialog(parentComponent, message, title, ERROR_MESSAGE);
	}

	public static void showExceptionMessageDialog() {
		String title   = "Exception!";
		String message = "A problem occurred while creating the error report.";
		
		showMessageDialog(null, message, title, ERROR_MESSAGE);
		
	}

}
