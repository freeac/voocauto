package com.vooc.main;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.vooc.Utils.GetPropertiesFile;

import io.appium.java_client.android.AndroidDriver;

public class AppiumAndroidDriver {
	public static WebDriver driver;

	public static WebDriver LoadAndroidDriver() {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, GetPropertiesFile.GetContentPropFile("AppDir"));
		File app = new File(appDir, GetPropertiesFile.GetContentPropFile("AndroidApp"));

		DesiredCapabilities caps = new DesiredCapabilities();

		if (!GetPropertiesFile.GetContentPropFile("AndroidDeviceName").toUpperCase().equals("NONE")) {
			caps.setCapability("deviceName", GetPropertiesFile.GetContentPropFile("AndroidDeviceName"));
		}

		if (!GetPropertiesFile.GetContentPropFile("AndroidUdid").toUpperCase().equals("NONE")) {
			caps.setCapability("udid", GetPropertiesFile.GetContentPropFile("AndroidUdid"));
		}

		if (!GetPropertiesFile.GetContentPropFile("AndroidPlatformName").toUpperCase().equals("NONE")) {
			caps.setCapability("platformName", GetPropertiesFile.GetContentPropFile("AndroidPlatformName"));
		}

		if (!GetPropertiesFile.GetContentPropFile("AndroidPlatformVersion").toUpperCase().equals("NONE")) {
			caps.setCapability("platformVersion", GetPropertiesFile.GetContentPropFile("AndroidPlatformVersion"));
		}

		if (!GetPropertiesFile.GetContentPropFile("AndroidApp").toUpperCase().equals("NONE")) {
			caps.setCapability("app", app.getAbsolutePath());
		}

		if (!GetPropertiesFile.GetContentPropFile("AndroidAppPackage").toUpperCase().equals("NONE")) {
			caps.setCapability("appPackage", GetPropertiesFile.GetContentPropFile("AndroidAppPackage"));
		}

		if (!GetPropertiesFile.GetContentPropFile("AndroidAppActivity").toUpperCase().equals("NONE")) {
			caps.setCapability("appActivity", GetPropertiesFile.GetContentPropFile("AndroidAppActivity"));
		}

		if (!GetPropertiesFile.GetContentPropFile("AndroidResetKeyboard").toUpperCase().equals("NONE")) {
			caps.setCapability("resetKeyboard", GetPropertiesFile.GetContentPropFile("AndroidResetKeyboard"));
		}

		if (!GetPropertiesFile.GetContentPropFile("AndroidUnicodeKeyboard").toUpperCase().equals("NONE")) {
			caps.setCapability("unicodeKeyboard", GetPropertiesFile.GetContentPropFile("AndroidUnicodeKeyboard"));
		}

		if (!GetPropertiesFile.GetContentPropFile("AndroidNoReset").toUpperCase().equals("NONE")) {
			caps.setCapability("noReset", GetPropertiesFile.GetContentPropFile("AndroidNoReset"));
		}

		if (!GetPropertiesFile.GetContentPropFile("AndroidBundleId").toUpperCase().equals("NONE")) {
			caps.setCapability("bundleId", GetPropertiesFile.GetContentPropFile("AndroidBundleId"));
		}

		if (!GetPropertiesFile.GetContentPropFile("AndroidAutomationName").toUpperCase().equals("NONE")) {
			caps.setCapability("automationName", GetPropertiesFile.GetContentPropFile("AndroidAutomationName"));
		}

		if (!GetPropertiesFile.GetContentPropFile("AndroidXCodeConfigfile").toUpperCase().equals("NONE")) {
			caps.setCapability("xcodeConfigfile", GetPropertiesFile.GetContentPropFile("AndroidXCodeConfigfile"));
		}

		if (!GetPropertiesFile.GetContentPropFile("AndroidStartIWDP").toUpperCase().equals("NONE")) {
			caps.setCapability("startIWDP", GetPropertiesFile.GetContentPropFile("AndroidStartIWDP"));
		}

		try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
}
