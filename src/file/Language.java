package file;

import java.util.Vector;

public class Language {
	// Attributes
	private String 		  langName	= null;
	private Vector<Entry> entries 	= new Vector<>();

	public Language(String langName) { this.langName = langName; }

	public String getLangName() { return langName; }
	
	public Vector<String> getIDList(){
		Vector<String> idList = new Vector<>();
		
		for(Entry entry : entries) { idList.add(entry.getID()); }
		
		return idList;
	}

	public void addEntry(String id, String textContent) { entries.add(new Entry(id, textContent)); }

	public String getTextContent(int index) { 
		
		if(index == -1) {
			return null;
		}
		
		return entries.get(index).getTextContent(); 
	}

	public void setTextContent(int index, String textContent) { 
		
		if(index == -1) {
			return;
		}
		
		entries.get(index).setTextContent(textContent); 
	}
	
	public Vector<Entry> getEntries() { return entries; }
	
	public int getEntryCount() { return entries.size(); }

	// Inner Class
	public class Entry {

		private String id 	   	   = null;
		private String textContent = null;

		private Entry(String id, String textContent) {
			this.id 		 = id;
			this.textContent = textContent;
		}

		public String getID() { return id; }

		public String getTextContent() { return textContent; }

		public void setTextContent(String textContent) { this.textContent = textContent; }

	}

}
