package com.vooc.TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features/Umbalena/APi", glue = { "com.vooc.StepDefinition", "com.vooc.Hooks" }, plugin = {
		"pretty", 
		"json:target/cucumber-reports/Cucumber.json", 
		"junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports" })
public class TestRunner {

}
