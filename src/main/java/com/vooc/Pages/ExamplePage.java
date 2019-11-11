package com.vooc.Pages;

import org.junit.Assert;

import com.vooc.Utils.GetPropertiesFile;
import com.vooc.Utils.JsonFile;
import com.vooc.Utils.Logger;

public class ExamplePage extends CommonPage {
	Logger log = new Logger();
	public void AccessToAppUrl() throws Exception {
		Browser().get(GetPropertiesFile.GetContentPropFile("AppUrl"));
		log.Info("Access " + GetPropertiesFile.GetContentPropFile("AppUrl"));
	}

	public void ClickAcceptButtonAndInputElement() throws Exception {
		ControlButton("AcceptButton").Click();
		ControlButton("FirstName").RightClick();
	}

	public void ShowStringToUTF8() throws Exception {
		String a = JsonFile.FindValueByKey("LoginPage", "UserName", "xpath");
		String b = JsonFile.FindValueByKey("LoginPage", "Password", "xpath");
		String c = JsonFile.FindValueByKey("LoginPage", "SubmitButton", "xpath");
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
		log.Info(a);
		log.Info(b);
		log.Info(c);
	}
	
	public void VerifyToFail() {
		String exp = "abc";
		String act = "def";
		log.Info("Actual: " + act + " - " + "Expected: " + exp);
		Assert.assertTrue(exp.equals(act));	
	}
	
	public void VerifyToPass() {
		String exp = "abc";
		String act = "abc";
		log.Info("Actual: " + act + " - " + "Expected: " + exp);
		Assert.assertTrue(exp.equals(act));
	}
}
