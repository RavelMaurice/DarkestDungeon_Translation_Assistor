package file;

import java.util.Vector;

@SuppressWarnings("unchecked")
public class IntegrityIssue {

	enum IssueType {
		MISSED_OR_FINDED_ID;
	}

	private IssueType issueType = null;
	private Vector<Object> issueItems = new Vector<>();

	public IntegrityIssue(IssueType issueType) {
		this.issueType = issueType;
	}

	public IssueType getIssueType() {
		return issueType;
	}

	public void addItem(Object item) {
		this.issueItems.add(item);
	}

	public Object getItem(int i) {
		return issueItems.get(i);
	}

	public String getIssueReport() {

		String report = "";

		if (issueType == IssueType.MISSED_OR_FINDED_ID) {

			Language standard = (Language) issueItems.get(0);
			Language lang = (Language) issueItems.get(1);
			Vector<String> finded = (Vector<String>) issueItems.get(2);
			Vector<String> missed = (Vector<String>) issueItems.get(3);

			report += "<pre>\n";
			report += "The entries of <b>" + lang.getLangName() + "</b> has finded or missed entry. (Standard Language : "
					+ standard.getLangName() + ")\n\n";

			if (finded.size() > 0) {
				report += "\n    The following is finded : \n";

				for (String id : finded) {
					report += "        - " + id + "\n";
				}
			}

			if (missed.size() > 0) {
				report += "\n    The following is missed : \n";

				for (String id : missed) {
					report += "        - " + id + "\n";
				}
			}
			
			report += "\n</pre>\n";

		}

		return report;
	}

}
