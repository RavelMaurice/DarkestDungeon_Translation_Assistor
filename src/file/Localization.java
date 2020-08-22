package file;

import java.util.Vector;

public class Localization {
	// Attributes
	public Vector<Language> languages = new Vector<>();
	public Vector<String> ids = new Vector<>();

	public void addLanguage(String langName) {
		this.languages.add(new Language(langName));
	}

	private void addEntry(String langName, String entry) {

		for (Language lang : languages) {

			if (lang.getName().equals(langName)) {
				lang.addEntry(entry);
				break;
			}

		}
	}

	public void addEntry(String name, String entry, String id) {
		addEntry(name, entry);

		if (languages.size() < 2) {
			this.ids.add(id);
		}

	}

	public Vector<String> getEntryIDs() {
		return ids;
	}

	public Vector<Language> getLanguages() {
		return languages;
	}

	public String getEntry(String name, int index) {

		for (Language lang : languages) {

			if (lang.getName().equals(name)) {
				return lang.getContent(index);
			}

		}

		return "";

	}

	// Inner Class
	public class Language {

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

		public String getContent(int index) {
			return entries.get(index);
		}

		public void setContent(int index, String content) {
			this.entries.set(index, content);
		}

		public Vector<String> getEntries() {
			return entries;
		}

	}

	public void setEntry(String name, int index, String content) {
		for (Language lang : languages) {
			if (lang.getName().equals(name)) {
				lang.setContent(index, content);
			}
		}
	}

	public String checkIntegrity() {
		
		int countID = ids.size();

		for (Language lang : languages) {
			if (lang.getEntries().size() != countID) {
				System.out.println(lang.getName() + "is" + lang.getEntries().size() + ", Default is" + countID);
			}
		}
		
		return null;
	}

}
