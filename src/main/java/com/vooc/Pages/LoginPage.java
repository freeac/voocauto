package com.vooc.Pages;

import org.junit.Assert;

import com.vooc.Utils.GetPropertiesFile;

public class LoginPage extends CommonPage {
	public void InputUserName() throws Exception {
		ControlInput("UserName").InputValueMobile(GetPropertiesFile.GetContentPropFile("UserUmbalena"));
		System.out.println(getClass().getSimpleName() + " - Input Username ["
				+ GetPropertiesFile.GetContentPropFile("UserUmbalena") + "]");
	}

	public void InputPassword() throws Exception {
		ControlInput("Password").InputValueMobile(GetPropertiesFile.GetContentPropFile("PassUmbalena"));
		System.out.println(getClass().getSimpleName() + " - Input Password ["
				+ GetPropertiesFile.GetContentPropFile("PassUmbalena") + "]");
	}

	public void ClickSubmitButton() throws Exception {
		ControlButton("SubmitButton").Click();
		System.out.println(getClass().getSimpleName() + " - Click Submit Button");
	}

	public void CheckMsgBoxDisplay() throws Exception {
		String act = ControlInput("Message").GetText();
		String exp = "Tên đăng nhập hoặc số điện thoại không chính xác.";
		System.out.println(act);
		System.out.println(exp);
		Assert.assertTrue(act.equals(exp));
	}

	public void VerifyContentMsgBox() throws Exception {
		String act = ControlInput("Message").GetText();
		String exp = "Tên đăng nhập hoặc số điện thoại không chính xác. Vui lòng kiểm tra lại";
		System.out.println(act);
		System.out.println(exp);
		Assert.assertTrue(act.equals(exp));
	}
}
