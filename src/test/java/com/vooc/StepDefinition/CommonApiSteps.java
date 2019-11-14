package com.vooc.StepDefinition;

import java.util.List;

import com.vooc.Pages.CommonApi;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

public class CommonApiSteps extends CommonApi {
	@Given("^Execute call \"(.*)\" APi with uri: \"(.*)\"$")
	public void ExecuteAPiWithUri(String type, String apiUri) throws Throwable {
		CallApiWithUri(type, apiUri);
	}
	
	@Given("^Execute call \"(.*)\" method with \"(.*)\" APi and uri: \"(.*)\"$")
	public void ExecuteAPiWithUriAndName(String type, String apiName, String apiUri) throws Throwable {
		CallApiWithNameAndUri(type, apiName, apiUri);
	}

	@Given("^Execute call \"(.*)\" method with uri: \"(.*)\" and token$")
	public void ExecuteAPiWithUriToken(String type, String apiUri) throws Throwable {
		CallApiWithUriToken(type, apiUri);
	}

	@Given("^Execute call GET method with uri: \"(.*)\" have params below$")
	public void ExecuteAPiWithUriHaveParams(String apiUri, DataTable params) throws Throwable {
		List<List<String>> list = params.raw();
		CallApiWithUriHaveParams(apiUri, list);
	}

	@Given("^Execute check status \"(.*)\" response is true$")
	public void ExecuteCheckStatusResponse(String status) throws Throwable {
		CheckStatusResponse(status);
	}

	@Given("^Execute check header response as below$")
	public void ExecuteCheckHeaderResponse(DataTable headerRes) throws Throwable {
		List<List<String>> list = headerRes.raw();
		CheckHeaderResponse(list);
	}

	@Given("^Execute check body response with \"(.*)\" key as below$")
	public void ExecuteCheckContentResponse(String key, DataTable bodyRes) throws Throwable {
		List<List<String>> list = bodyRes.raw();
		CheckContentResponse(key, list);
	}
	
	@Given("^Execute call POST method nobody with uri: \"(.*)\" and token$")
	public void ExecutePostApiWithNoBody(String apiUrl) throws Throwable {
		CallApiWithNoBody(apiUrl);
	}
}
