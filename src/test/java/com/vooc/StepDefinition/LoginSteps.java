package com.vooc.StepDefinition;

import com.vooc.Pages.LoginPage;

import cucumber.api.java.en.Given;

public class LoginSteps extends LoginPage{
  @Given("^I execute login app with user and pass$")
  public void ExecuteLoginAppWithUserPass() throws Throwable {
	  InputUserName();
	  InputPassword();
	  ClickSubmitButton();
  }
  
  @Given("^I verify user login app is success$")
  public void VerifyUserLoginAppSuccess() throws Throwable {
	  VerifyContentMsgBox();
  }
  
  @Given("^I verify message when user login fail$")
  public void VerifyMsgUserLoginFail() throws Throwable {
	  CheckMsgBoxDisplay();
	  
  }

}
