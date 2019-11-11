package com.vooc.Utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	public void Info(String inf) {
		WriteLog(inf);
	}

	private void WriteLog(String logMsg) {
		String logPath = System.getProperty("user.dir") + "\\Logs";
		String logName = "Log";
		String filePath = logPath + "\\" + logName + ".txt";
		FolderFile.CheckCreateFolder(logPath);
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true), "utf-8"));
			Log(logMsg, writer);
			System.out.println(logMsg);
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

	private void Log(String log, Writer w) {
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd hh.mm.ss");
		String content = String.format("%s ==> %s", ft.format(date), log);
		try {
			w.append(content);
			w.append("\r\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
