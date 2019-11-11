package com.vooc.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriver {
	public static WebDriver LoadChromeDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\app\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}
}
