package com.vooc.Extensions;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.vooc.Drivers.Driver;
import com.vooc.Utils.FolderFile;

public class DriverExtensions extends Driver {
	public static void DeleteAllCookie() {
		Browser().manage().deleteAllCookies();
	}

	public static String GetCurrentAppUrl() {
		return Browser().getCurrentUrl();
	}

	public static void TakeScreenShot(WebDriver driver, String path, String nameShot) {
		String filePath = path + "//" + nameShot + ".png";
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File source = scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void TakeScreenShot(WebDriver driver, String scenario) {
		String path = System.getProperty("user.dir") + "//Screenshot//" + scenario + ".png";
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File source = scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void GetPageSource(WebDriver driver, String path, String nameSou) {
		String filePath = path + "//" + nameSou + ".html";
		String source = driver.getPageSource();
		FolderFile.CreateFileAnyExtension(filePath, source);
	}

	public static void GetPageSource(WebDriver driver, String scenario) {
		String path = System.getProperty("user.dir") + "//Screenshot//" + scenario + ".html";
		String source = driver.getPageSource();
		FolderFile.CreateFileAnyExtension(path, source);
	}
}
