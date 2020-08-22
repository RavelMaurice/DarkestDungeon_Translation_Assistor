package file;

import java.util.Vector;

public class Language {
	// Attributes
	private String langName = null;
	private Vector<Entry> entries = new Vector<>();

	public Language(String langName) {
		this.langName = langName;
	}

	public String getLangName() {
		return langName;
	}
	
	public Vector<String> getIDList(){
		Vector<String> idList = new Vector<>();
		
		for(Entry entry : entries) {
			idList.add(entry.getID());
		}
		
		return idList;
	}

	public void addEntry(String id, String content) {
		this.entries.add(new Entry(id, content));
	}

	public String getContent(int index) {
		return entries.get(index).getContent();
	}

	public void setContent(int index, String content) {
		this.entries.get(index).setContent(content);
	}
	
	public int getEntryCount() {
		return entries.size();
	}

	// Inner Class
	private class Entry {

		private String id = null;
		private String content = null;

		private Entry(String id, String content) {
			this.id = id;
			this.content = content;
		}

		public String getID() {
			return id;
		}

		private String getContent() {
			return content;
		}

		private void setContent(String content) {
			this.content = content;
		}

	}

}
