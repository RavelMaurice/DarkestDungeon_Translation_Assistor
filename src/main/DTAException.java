package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.Dialog;

public class DTAException {

	public static void createReport(Exception e) {
		// Create Exception Report File
		String fileName = "Exception_Report_" + new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());

		File file = new File(DTAPath.ERROR_REPORT_PATH + fileName + ".txt");

		try {

			FileWriter writer = new FileWriter(file, true);

			String message = e.getMessage() == null ? "null" : e.getMessage();
			String cause   = e.getCause()   == null ? "null" : e.getCause().toString();

			writer.write("Message : " + message + "\n");
			writer.write("Cause : " + cause + "\n");
			writer.write("Description : " + "\n\n");

			for (StackTraceElement traceElement : e.getStackTrace()) {
				writer.write(traceElement.toString() + "\n");
			}
			
			writer.flush();
			writer.close();

		} catch (IOException ioe) {
			Dialog.showExceptionMessageDialog();
			System.exit(0);
		}
		
		e.printStackTrace();

	}

}
