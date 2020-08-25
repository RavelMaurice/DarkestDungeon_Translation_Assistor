package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import main.DTAException;
import main.DTAPath;

public class IntegrityReport {	
	// Attributes
	private static Vector<IntegrityIssue> issues = new Vector<>();

	public static void addIssue(IntegrityIssue issue) { issues.add(issue); }

	public static int getIssueCount() { return issues.size(); }

	public static void flush() { issues.clear(); }

	public static void writeReport() {

		if (getIssueCount() == 0) { return; }

		String fileName = "IVReport_"
				+ new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());

		File file = new File(DTAPath.INTEGRITY_VERIFICATION_REPORT_PATH + fileName + ".html");

		try {

			FileWriter writer = new FileWriter(file, true);
			
			// Write Header
			writer.write("<!doctype html>\n");
			writer.write("<html>\n");
			writer.write("<head>\n");
			writer.write("<h1>Integrity Verification Report</h1>\n");
			writer.write("</head>\n");
			writer.write("<body>\n");
			

			for (IntegrityIssue issue : issues) {
				writer.write("<p>\n" + issue.getParagraph() + "\n</p>\n");
			}
			
			writer.write("</body>\n");
			writer.write("</html>");

			writer.flush();
			writer.close();

			
		} catch (IOException e) { DTAException.createReport(e); }

	}

}
