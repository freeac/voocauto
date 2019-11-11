package com.vooc.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FolderFile {
	public static boolean CheckCreateFolder(String folPath) {
		boolean fol = true;
		File file = new File(folPath);
		if (!file.exists()) {
			fol = false;
			file.mkdir();
		} else {
			fol = true;
		}
		return fol;
	}
	
	public static void CreateFileAnyExtension(String filePath, String txt) {		
 		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true), "utf-8"));
			writer.write(txt);
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
	
	public static String CombineStrWithoutSpecialChar(String txt, String ch) {
		String StrCom = "";
		String[] str = txt.split(ch);
		for(int i = 0 ; i < str.length; i++) {
			StrCom = StrCom + str[i];
		}
		return StrCom;
	}
	
	public static String ReplaceAnyChar(String txt, String anyChar, String ch) {
		String RepCh = txt;
		String[] str = anyChar.split("|");
		for(int i = 0 ; i < str.length; i++) {
			RepCh = RepCh.replace(str[i], ch);
		}
		return RepCh;
	}
}
