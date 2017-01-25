package util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyReader {

	private static Map<String, Properties> properties = new HashMap<String, Properties>();

	private static PropertyReader instance;

	private PropertyReader() {

	}

	public static PropertyReader getInstance() {
		if (instance == null) {
			instance = new PropertyReader();
		}
		return instance;
	}

	public Properties getProperties(String fileName) {
		if (!properties.containsKey(fileName)) {
			Properties props = new Properties();
			FileReader fileReader = null;
			try {
				fileReader = new FileReader(new File(fileName));
				props.load(fileReader);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			} finally {
				if (fileReader != null) {
					try {
						fileReader.close();
					} catch (IOException e) {
						throw new RuntimeException(e.getMessage(), e);
					}
				}
			}

			properties.put(fileName, props);
		}
		return properties.get(fileName);
	}

	public String getProperty(String propsFileName, String key) {
		return getProperties(propsFileName).getProperty(key);
	}
}
