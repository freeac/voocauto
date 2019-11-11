package com.vooc.Drivers;

import org.openqa.selenium.WebDriver;

import com.vooc.Utils.CommandLines;
import com.vooc.main.AppiumAndroidDriver;
import com.vooc.main.AppiumIosDriver;
import com.vooc.main.ChromeWebDriver;

public class DriverController {
	public static DriverController Instance = new DriverController();
	public WebDriver driver;

	public void StartChromeDriver() {
		if (driver != null)
			return;
		driver = ChromeWebDriver.LoadChromeDriver();
	}

	public void StartAndroidDriver() {
		if (driver != null)
			return;
		driver = AppiumAndroidDriver.LoadAndroidDriver();
	}

	public void StartIosDriver() {
		if (driver != null)
			return;
		driver = AppiumIosDriver.LoadIosDriver();
	}

	public void StopWebDriver() {
		if (driver == null)
			return;
		try {
			driver.quit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(":: WebDriver stop error : " + e);
		}
		driver = null;
		CommandLines.ExecuteCommandLine("taskkill /IM chromedriver.exe");
	}

	public void StopMobileDriver() {
		if (driver == null)
			return;
		try {
			driver.quit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(":: WebDriver stop error : " + e);
		}
		driver = null;
	}
}
