package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;

public class IOUtil {

	public static URL getFileInClassPath(String fileName) {
		URL fileURL = ClassLoader.getSystemResource(fileName);
		
		return fileURL;
	}
	
	public static String readFileInClassPath(String fileName) {
		URL fileURL = ClassLoader.getSystemResource(fileName);

		// read file line by line
		StringBuilder buffer = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileURL.getPath()))) {
			String line;
			while (((line = reader.readLine()) != null)) {
				buffer.append(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return buffer.toString();
	}
	
	public static void delete(File file) {
		if(file == null)
			return;
		
		if(file.isDirectory())
			for(File f : file.listFiles())
				delete(f);
		
		file.delete();
	}
	
	public static  void printPaths(List<Path> paths) {
		for(Path path : paths) {
			System.out.println(path.toString());
		}
	}
}
