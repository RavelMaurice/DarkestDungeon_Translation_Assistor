package file;

import java.util.Vector;

@SuppressWarnings("unchecked")
public class IntegrityIssue {

	enum IssueType {
		MISSED_OR_FINDED_ID;
	}

	private IssueType 	   issueType  = null;
	private Vector<Object> issueItems = new Vector<>();

	public IntegrityIssue(IssueType issueType) { this.issueType = issueType; }

	public IssueType getIssueType() { return issueType; }

	public void addItem(Object item) { issueItems.add(item); }

	public Object getItem(int i) { return issueItems.get(i); }

	public String getParagraph() {

		String report = "";

		report += "<pre>\n";

		if (issueType == IssueType.MISSED_OR_FINDED_ID) {
			// Get Items
			Language standard = (Language) issueItems.get(0);
			Language lang = (Language) issueItems.get(1);
			Vector<String> finded = (Vector<String>) issueItems.get(2);
			Vector<String> missed = (Vector<String>) issueItems.get(3);

			report += "The entries of <b>" + lang.getLangName()
					+ "</b> has finded or missed entry. (Standard Language : " + standard.getLangName() + ")\n\n";

			// Write Finded Entries
			if (finded.size() > 0) {
				report += "\n    The following is finded : \n";

				for (String id : finded) {
					report += "        - " + id + "\n";
				}
			}

			// Write Missed Entries
			if (missed.size() > 0) {
				report += "\n    The following is missed : \n";

				for (String id : missed) {
					report += "        - " + id + "\n";
				}
			}

		}

		report += "\n</pre>\n";

		return report;
	}

}
