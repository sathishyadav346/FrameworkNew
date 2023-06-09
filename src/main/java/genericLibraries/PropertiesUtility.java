package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * THis class contains reusable methods to perform actions on properties file
 * 
 * @author HP
 *
 */
public class PropertiesUtility {
	private Properties property;

	/**
	 * This method
	 * 
	 * @param args
	 * @param filePath
	 * @param Property
	 * @return
	 */

	public void propertiesInit(String filePath) {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties property = new Properties();
		try {
			property.load(fis);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public String fetchDataFromProperties(String key) {
		return property.getProperty(key);
	}

	public void writeDataToProperties(String key, String value, String filePath, String comments) {
		property.put(key, value);
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(filePath);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			property.store(fos, comments);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
