package com.vooc.StepDefinition;

import com.vooc.Pages.CommonPage;

import cucumber.api.java.en.Given;

public class CommonSteps extends CommonPage{
  @Given("Execute login Umbalena app by default user$")
  public void ExecuteLoginUmbalenaByDefaultUser() throws Throwable {
	  LoginUmbalenaByDefaultUser();
  }

}
