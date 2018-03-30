package com.microsilver.mrcard.scheduledtask.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	/**
	 * 获取配置文件
	 * 
	 * @param filename
	 */
	public static Properties loadProperties(String filename) {
		Properties prop = new Properties();
		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
		try {
			prop.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return prop;
	}
}
