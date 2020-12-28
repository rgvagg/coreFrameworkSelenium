package quickStart.selenium.coreFramework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {

	private static String valueOfKey;
	private static String workingDir = System.getProperty("user.dir");
	private static String configFilePathString = workingDir+"//src//test//resources//config.properties";

	public static String readProperty(String key) throws IOException {
		File filepathFile = new File(configFilePathString);
		FileInputStream fileInputStream;

		fileInputStream = new FileInputStream(filepathFile);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		valueOfKey = properties.getProperty(key);
		return valueOfKey;

	}

	public static boolean isPropertyValueExpected(String property, String expectedValue) throws IOException {
		return readProperty(property).toLowerCase().equals(expectedValue);
	}

}
