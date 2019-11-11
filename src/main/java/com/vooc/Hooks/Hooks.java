package com.vooc.Hooks;

import com.vooc.Drivers.Driver;
import com.vooc.Drivers.DriverController;
import com.vooc.Extensions.DriverExtensions;
import com.vooc.Utils.DateCommon;
import com.vooc.Utils.FolderFile;
import com.vooc.Utils.GetPropertiesFile;
import com.vooc.Utils.Logger;
import com.vooc.Utils.MailMess;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends Driver {
	Logger log = new Logger();

	@Before(order = 1)
	public void SetUp(Scenario scenario) {
		if (GetPropertiesFile.GetContentPropFile("ChromeDriverUse").equals("1")) {
			DriverController.Instance.StartChromeDriver();
			log.Info(":::: " + scenario.getName() + " ::::");
			log.Info(":: WebDriver is started ::");
		}

		if (GetPropertiesFile.GetContentPropFile("AndroidDriverUse").equals("1")) {
			DriverController.Instance.StartAndroidDriver();
			System.out.println(":::: " + scenario.getName() + " ::::");
			log.Info(":::: " + scenario.getName() + " ::::");
			log.Info(":: WebDriver is started ::");
		}

		if (GetPropertiesFile.GetContentPropFile("IosDriverUse").equals("1")) {
			DriverController.Instance.StartIosDriver();
			log.Info(":::: " + scenario.getName() + " ::::");
			log.Info(":: WebDriver is started ::");
		}

		if (GetPropertiesFile.GetContentPropFile("APiUse").equals("1")) {
			log.Info(":::: " + scenario.getName() + " ::::");
			log.Info(":: APi is started ::");
		}
	}

	@Before(order = 2)
	public void beforeScenario() {
		log.Info(":: Scenario is Started ::");
	}

	@After(order = 2)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String FeaScenName = FolderFile.ReplaceAnyChar(scenario.getId(), ";|-", "_");
			String datetime = DateCommon.DateFormat("yyyyMMddhhmmss");
			String FileName = FeaScenName + "_" + datetime;
			log.Info("::Result ==> Failed");

			if (GetPropertiesFile.GetContentPropFile("APiUse").equals("1")) {
				if (GetPropertiesFile.GetContentPropFile("EmailFlag").equals("1")) {
					MailMess.SendMail(GetPropertiesFile.GetContentPropFile("APiUrl") + scenario.getName());
				}
				if (GetPropertiesFile.GetContentPropFile("SMSFlag").equals("1")) {
					MailMess.SendSMS(GetPropertiesFile.GetContentPropFile("APiUrl") + scenario.getName());
				}
			}

			if (GetPropertiesFile.GetContentPropFile("ChromeDriverUse").equals("1")) {
				DriverExtensions.TakeScreenShot(Browser(), FileName);
				DriverExtensions.GetPageSource(Browser(), FileName);
			}
		} else {
			log.Info("::Result ==> Passed");
		}
		log.Info(":: Scenario is Stopped ::");
	}

	@After(order = 1)
	public void TearDown() {
		if (GetPropertiesFile.GetContentPropFile("ChromeDriverUse").equals("1")) {
			DriverController.Instance.StopWebDriver();
			log.Info(":: WebDriver is Stopped ::");
		}

		if (GetPropertiesFile.GetContentPropFile("AndroidDriverUse").equals("1")) {
			DriverController.Instance.StopMobileDriver();
			log.Info(":: WebDriver is Stopped ::");
		}

		if (GetPropertiesFile.GetContentPropFile("IosDriverUse").equals("1")) {
			DriverController.Instance.StopMobileDriver();
			log.Info(":: WebDriver is Stopped ::");
		}

		if (GetPropertiesFile.GetContentPropFile("APiUse").equals("1")) {
			log.Info(":: APi is Stopped ::");
		}

	}
}
