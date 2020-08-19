package file;

import java.util.Vector;

public class Localization {
	// Attributes
	public Vector<Language> languages = new Vector<>();
	public Vector<String> ids = new Vector<>();
	
	private boolean bIdInitialized = false;
	
	public void addLanguage(String name) {
		this.languages.add(new Language(name));
	}
	
	public void addEntry(String name, String entry) {
		for(Language lang : languages) {
			if(lang.getName().equals(name)) {
				lang.addEntry(entry);
				break;
			}
		}
	}
	
	public void addEntry(String name, String entry, String id) {
		addEntry(name, entry);
		this.ids.add(id);
	}
	
	public void setIDInitialized(boolean b) {
		this.bIdInitialized = b;
	}
	
	public boolean isIDInitialized() {
		return bIdInitialized;
	}
	
	public Vector<String> getEntryIDs(){
		return ids;
	}

	// Inner Class
	private class Language {
		
		private String name = null;
		private Vector<String> entries = null;

		public Language(String name) {
			this.name = name;
			this.entries = new Vector<>();
		}
		
		public String getName() {
			return name;
		}
		
		public void addEntry(String entry) {
			this.entries.add(entry);
		}
		
	}

}
