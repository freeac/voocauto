package com.vooc.Utils;

public class CommandLines {
	public static void ExecuteCommandLine(String scr) {
		try {
			ProcessBuilder processBuilder = new ProcessBuilder();
			processBuilder.command("cmd.exe", "/c", scr);
			Process process = processBuilder.start();
			process.waitFor();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(":: Execute command line error :" + e);
		}

	}
}
