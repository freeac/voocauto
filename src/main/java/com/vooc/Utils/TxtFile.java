package com.vooc.Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TxtFile {
	public static void ExecuteWriteToken(String inf) {
		WriteTokenToFile(inf);
	}

	public static String ExecuteReadToken() {
		String tokenPath = System.getProperty("user.dir");
		String tokenName = "Token";
		String filePath = tokenPath + "\\" + tokenName + ".txt";
		String str = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			str = br.readLine();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return str;
	}

	private static void WriteTokenToFile(String str) {
		String tokenPath = System.getProperty("user.dir");
		String tokenName = "Token";
		String filePath = tokenPath + "\\" + tokenName + ".txt";
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, false), "utf-8"));
			WriteToken(str, writer);
		} catch (Exception ex) {
			// ***
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
	}

	private static void WriteToken(String str, Writer w) {
		try {
			w.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
