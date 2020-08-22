package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class DTAException {
	// Constants
	private static final String REPORT_EXTENSION = ".txt";

	public static void createReport(Exception e) {
		// Create Exception Report File
		String fileName = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());

		File file = new File(DTAPath.EXCEPTION_REPORT_PATH + fileName + REPORT_EXTENSION);

		try {

			FileWriter writer = new FileWriter(file, true);

			String message = e.getMessage() == null ? "null" : e.getMessage();
			String cause = e.getCause() == null ? "null" : e.getCause().toString();

			writer.write("Message : " + message + "\n");
			writer.write("Cause : " + cause + "\n\n");

			for (StackTraceElement traceElement : e.getStackTrace()) {
				writer.write(traceElement.toString() + "\n");
			}
			
			writer.flush();
			writer.close();

		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "A problem occurred while creating the error report.", "Fatal error",
					JOptionPane.ERROR_MESSAGE);

			System.exit(0);
		}
		
		e.printStackTrace();

	}

}
