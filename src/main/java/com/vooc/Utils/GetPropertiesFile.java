package com.vooc.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class GetPropertiesFile {
	public static String GetContentPropFile(String key) {
		String val = "";
		Properties prop = new Properties();
		try {
			FileInputStream ips = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
			prop.load(ips);
			val = prop.getProperty(key).toString();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(":: Get content property file error :" + e);
		}
		return val;
	}
}
