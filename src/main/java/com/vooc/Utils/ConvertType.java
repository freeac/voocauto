package com.vooc.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ConvertType {
	public static String ConvertIntToString(int i) {
		String val = String.valueOf(i);
		return val;
	}

	public static String ConvertStringToUTF8(String str) {
		String val = new String(str.getBytes(), Charset.forName("UTF-8"));
		return val;
	}

	public static double ConvertStringToDouble(String str) {
		double db = Double.parseDouble(str);
		return db;
	}

	public static int ConvertStringToInt(String str) {
		int i = Integer.parseInt(str);
		return i;
	}

	public static String convertStreamToString(InputStream is) {
		StringBuilder sb = null;
		String line = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			sb = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
