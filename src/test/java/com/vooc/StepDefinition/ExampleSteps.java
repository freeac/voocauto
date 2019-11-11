package com.vooc.StepDefinition;

import com.vooc.Pages.ExamplePage;

import cucumber.api.java.en.Given;

public class ExampleSteps extends ExamplePage {
	@Given("^This is one$")
	public void ThisIsOne() throws Throwable {
		System.out.println("This is one");
	}

	@Given("^This is two$")
	public void ThisIsTwo() throws Throwable {
		System.out.println("This is two");
	}
	
	@Given("^This is Three$")
	public void ThisIsThree() throws Throwable {
		ShowStringToUTF8();
	}

	@Given("^I execute access to application url$")
	public void IExecuteAccessToAppUrl() throws Throwable {
		AccessToAppUrl();
	}
	
	@Given("^I execute click Accept button and right Click at first name$")
	public void IExecuteClickAceptButtonAndRightClick() throws Throwable {
		ClickAcceptButtonAndInputElement();
	}
	
	@Given("^I execute verify to fail$")
	public void IVerifyToFail() throws Throwable {
		VerifyToFail();
	}
	
	@Given("^I execute verify to Pass$")
	public void IVerifyToPass() throws Throwable {
		VerifyToPass();
	}
}
