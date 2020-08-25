package util;

import java.io.File;

public class FileUtil {
	
	public static String getExtension(File file) {
		String name = file.getName();
		
		return name.substring(name.lastIndexOf(".") + 1);
	}

}
