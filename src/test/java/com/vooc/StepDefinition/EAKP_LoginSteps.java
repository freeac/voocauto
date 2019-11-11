package com.vooc.StepDefinition;

import com.vooc.Pages.EAKP_LoginPage;

import cucumber.api.java.en.Given;

public class EAKP_LoginSteps extends EAKP_LoginPage{
	@Given("^Execute access into child account$")
	  public void ExecuteAccessIntoChildAcc() throws Throwable {
		AccessIntoChildAcc();
	  }
	
	@Given("^Execute input parent username \"(.*)\" in child account login$")
	public void ExecuteLoginUmlabenaWithUserPass(String user) throws Throwable {
		UmbalenaInputUsername(user);
	}
	
	@Given("^Execute click continue button$")
	public void ExecuteClickContinueButton() throws Throwable {
		UmbalenaClickContinueButton();
	}
	
	@Given("^Execute select child account$")
	public void ExecuteSelectChildAccount() throws Throwable {
		UmbalenaSelectChild();
	}
	
	@Given("^Execute click continue with child button$")
	public void ExecuteClickContinueWithChildButton() throws Throwable {
		UmbalenaClickContinueWithAnyoneButton();
	}
	
	@Given("^Execute choose password for child$")
	public void ExecuteChoosePasswordForChild() throws Throwable {
		UmbalenaChoosePasswordForChild();
	}
	
	@Given("^Verify name of profile is \"(.*)\"$")
	public void ExecuteVerifyProfileNameChild(String name) throws Throwable {
		VerifyChildLoginSuccess(name);
	}
	
	@Given("^Verify message is display when input username is wrong$")
	public void ExecuteVerifyMsgInputUserIncorrect() throws Throwable {
		VerifyMsgIsDisplay();
	}
}
