package com.vooc.Drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.vooc.Const.TimeConst;

public class Driver {
	public static WebDriver Browser() {
		return DriverController.Instance.driver;
	}

	public static void WaitBySecTime(int sec) {
		int time = sec * 1000;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void WaitByMinTime(int min) {
		int time = min * 1000 * 60;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void WaitPageLoadComplete(int time) {
		Browser().manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}
	
	public static void WaitForPageHasComplete() {
		WaitForPageHasStatus("complete");
	}

	public static void WaitForPageHasStatus(String status) {
		String _stage = ExecuteJavaScript("return document.readyState;").toString();
		for (int i = 1; i <= TimeConst.TimeSecWaitIsLong; i++) {
			if (_stage != status) {
				WaitBySecTime(i);
			} else {
				break;
			}
		}
	}

	public static Object ExecuteJavaScript(String script, Object[] args) {
		JavascriptExecutor js = (JavascriptExecutor) Browser();
		Object obj = js.executeScript(script, args);
		return obj;
	}

	public static Object ExecuteJavaScript(String script) {
		JavascriptExecutor js = (JavascriptExecutor) Browser();
		Object obj = js.executeScript(script);
		return obj;
	}
}