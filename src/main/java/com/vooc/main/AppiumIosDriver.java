package com.vooc.main;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.vooc.Utils.GetPropertiesFile;

import io.appium.java_client.ios.IOSDriver;

public class AppiumIosDriver {
	public static WebDriver driver;

	public static WebDriver LoadIosDriver() {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, GetPropertiesFile.GetContentPropFile("AppDir"));
		File app = new File(appDir, GetPropertiesFile.GetContentPropFile("IOSApp"));

		DesiredCapabilities caps = new DesiredCapabilities();
		if (!GetPropertiesFile.GetContentPropFile("IOSDeviceName").toUpperCase().equals("NONE")) {
			caps.setCapability("deviceName", GetPropertiesFile.GetContentPropFile("IOSDeviceName"));
		}

		if (!GetPropertiesFile.GetContentPropFile("IOSUdid").toUpperCase().equals("NONE")) {
			caps.setCapability("udid", GetPropertiesFile.GetContentPropFile("IOSUdid"));
		}

		if (!GetPropertiesFile.GetContentPropFile("IOSPlatformName").toUpperCase().equals("NONE")) {
			caps.setCapability("platformName", GetPropertiesFile.GetContentPropFile("IOSPlatformName"));
		}

		if (!GetPropertiesFile.GetContentPropFile("IOSPlatformVersion").toUpperCase().equals("NONE")) {
			caps.setCapability("platformVersion", GetPropertiesFile.GetContentPropFile("IOSPlatformVersion"));
		}

		if (!GetPropertiesFile.GetContentPropFile("AndroidApp").toUpperCase().equals("NONE")) {
			caps.setCapability("app", app.getAbsolutePath());
		}

		if (!GetPropertiesFile.GetContentPropFile("IOSAppPackage").toUpperCase().equals("NONE")) {
			caps.setCapability("appPackage", GetPropertiesFile.GetContentPropFile("IOSAppPackage"));
		}

		if (!GetPropertiesFile.GetContentPropFile("IOSAppActivity").toUpperCase().equals("NONE")) {
			caps.setCapability("appActivity", GetPropertiesFile.GetContentPropFile("IOSAppActivity"));
		}

		if (!GetPropertiesFile.GetContentPropFile("IOSResetKeyboard").toUpperCase().equals("NONE")) {
			caps.setCapability("resetKeyboard", GetPropertiesFile.GetContentPropFile("IOSResetKeyboard"));
		}

		if (!GetPropertiesFile.GetContentPropFile("IOSUnicodeKeyboard").toUpperCase().equals("NONE")) {
			caps.setCapability("unicodeKeyboard", GetPropertiesFile.GetContentPropFile("IOSUnicodeKeyboard"));
		}

		if (!GetPropertiesFile.GetContentPropFile("IOSNoReset").toUpperCase().equals("NONE")) {
			caps.setCapability("noReset", GetPropertiesFile.GetContentPropFile("IOSNoReset"));
		}

		if (!GetPropertiesFile.GetContentPropFile("IOSBundleId").toUpperCase().equals("NONE")) {
			caps.setCapability("bundleId", GetPropertiesFile.GetContentPropFile("IOSBundleId"));
		}

		if (!GetPropertiesFile.GetContentPropFile("IOSAutomationName").toUpperCase().equals("NONE")) {
			caps.setCapability("automationName", GetPropertiesFile.GetContentPropFile("IOSAutomationName"));
		}

		if (!GetPropertiesFile.GetContentPropFile("IOSXCodeConfigfile").toUpperCase().equals("NONE")) {
			caps.setCapability("xcodeConfigfile", GetPropertiesFile.GetContentPropFile("IOSXCodeConfigfile"));
		}

		if (!GetPropertiesFile.GetContentPropFile("IOSStartIWDP").toUpperCase().equals("NONE")) {
			caps.setCapability("startIWDP", GetPropertiesFile.GetContentPropFile("IOSStartIWDP"));
		}

		try {
			driver = new IOSDriver<WebElement>(new URL(GetPropertiesFile.GetContentPropFile("IOSUrl")), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
}
