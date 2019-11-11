package com.vooc.Pages;

import org.junit.Assert;

public class EAKP_LoginPage extends CommonPage {

	public void AccessIntoChildAcc() {
		ControlButton("AccessChildButton").Click();
		log.Info("Execute Click [Muốn vào tài khoản bé?] button");
	}

	public void UmbalenaInputUsername(String user) {
		ControlInput("UserParentInput").InputValueMobile(user);
		log.Info("Execute Input Parent Username");
	}

	public void UmbalenaClickContinueButton() {
		ControlButton("ContinueButton").Click();
		log.Info("Execute Click [Tiếp tục] button");
	}

	public void UmbalenaSelectChild() {
		ControlButton("SelectChildButton").Click();
		log.Info("Execute Select [Na] Child");
	}

	public void UmbalenaClickContinueWithAnyoneButton() {
		ControlButton("SubmitButton").Click();
		log.Info("Execute Click [Tiếp tục với bé Na] button");
	}

	public void UmbalenaChoosePasswordForChild() {
		ControlInput("PasswordButton").Click();
		log.Info("Execute Select Password");
	}

	public void VerifyChildLoginSuccess(String exp) {
		ControlIsExist("ProfileButton");
		ControlButton("ProfileButton").Click();
		log.Info("Execute click on profile of child");
		String act = ControlDiv("ProfileName").GetText();
		log.Info("Verify Name profile of child actual [" + act + "] expected [" + exp + "]");
		Assert.assertTrue(act.equals(exp));
	}
	
	public void VerifyMsgIsDisplay() {
		String exp = "Người dùng không tồn tại.";
		ControlIsExist("Message");
		String act = ControlDiv("Message").GetText();
		Assert.assertTrue(act.equals(exp));
	}
}
