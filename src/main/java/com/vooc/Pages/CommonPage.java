package com.vooc.Pages;

import com.vooc.Drivers.BaseControls;
import com.vooc.Utils.GetPropertiesFile;
import com.vooc.Utils.Logger;

public class CommonPage extends BaseControls {
	Logger log = new Logger();

	public void LoginUmbalenaByDefaultUser() {
		UmbalenaInputUsername();
		UmbalenaInputPassword();
		UmbalenaClickSubmitButton();
	}

	private void UmbalenaInputUsername() {
		ControlInput("UserName").InputValueMobile(GetPropertiesFile.GetContentPropFile("UserUmbalena"));
		log.Info("Execute Input Username");
	}

	private void UmbalenaInputPassword() {
		ControlInput("Password").InputValueMobile(GetPropertiesFile.GetContentPropFile("PassUmbalena"));
		log.Info("Execute Input Password");
	}

	private void UmbalenaClickSubmitButton() {
		ControlButton("SubmitButton").Click();
		log.Info("Execute Click [Đăng nhập] button");
	}
}
