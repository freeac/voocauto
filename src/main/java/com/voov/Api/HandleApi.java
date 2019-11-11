package com.voov.Api;

import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.vooc.Utils.GetPropertiesFile;
import com.vooc.Utils.JsonFile;

public class HandleApi {
	public HttpResponse ExecuteRequestGetMethodToUri(String _requestUri) {
		String requestUri = GetPropertiesFile.GetContentPropFile("APiUrl") + _requestUri;
		HttpResponse response = null;
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(requestUri);
		try {
			response = client.execute(request);
		} catch (Exception e) {
			e.getMessage();
		}
		return response;
	}

	public HttpResponse ExecuteRequestGetMethodToUriWithToken(String _requestUri, String token) {
		String requestUri = GetPropertiesFile.GetContentPropFile("APiUrl") + _requestUri;
		HttpResponse response = null;
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(requestUri);
		request.addHeader("Authorization", token);
		try {
			response = client.execute(request);
		} catch (Exception e) {
			e.getMessage();
		}
		return response;
	}

	public HttpResponse ExecuteRequestGetMethodToUriHaveParams(String _requestUri, List<List<String>> params,
			String token) {
		String requestUri = GetPropertiesFile.GetContentPropFile("APiUrl") + _requestUri + "?";
		for (int i = 0; i < params.get(0).size(); i++) {
			requestUri = requestUri + params.get(0).get(i) + "=" + params.get(1).get(i) + "&";
		}
		requestUri = requestUri.replaceFirst(".$", "");
		System.out.println(requestUri);
		HttpResponse response = null;
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(requestUri);
		request.addHeader("Authorization", token);
		try {
			response = client.execute(request);
		} catch (Exception e) {
			e.getMessage();
		}
		return response;
	}

	public HttpResponse ExecuteRequestPostMethodToUri(String _requestUri) {
		String requestUri = GetPropertiesFile.GetContentPropFile("APiUrl") + _requestUri;
		HttpResponse response = null;
		String ApiName = _requestUri.replaceAll(".$", "").replaceFirst("^.", "");
		String pageName = ApiName.replace("/", "-");
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(requestUri);
		Map<String, String> map = JsonFile.GetHeader(pageName);
		for (Map.Entry<String, String> entry : map.entrySet()) {
			request.addHeader(entry.getKey(), entry.getValue());
		}
		String _requestContent = JsonFile.GetBodyContent(pageName);
		try {
			StringEntity strEntity = new StringEntity(_requestContent);
			request.setEntity(strEntity);
			response = client.execute(request);
		} catch (Exception e) {
			e.getMessage();
		}
		return response;
	}

	public HttpResponse ExecuteRequestPostMethodToUriWithToken(String _requestUri, String token) {
		String requestUri = GetPropertiesFile.GetContentPropFile("APiUrl") + _requestUri;
		HttpResponse response = null;
		String ApiName = _requestUri.replaceAll(".$", "").replaceFirst("^.", "");
		String pageName = ApiName.replace("/", "-");
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(requestUri);
		request.addHeader("Authorization", token);
		Map<String, String> map = JsonFile.GetHeader(pageName);
		for (Map.Entry<String, String> entry : map.entrySet()) {
			request.addHeader(entry.getKey(), entry.getValue());
		}
		String _requestContent = JsonFile.GetBodyContent(pageName);
		try {
			StringEntity strEntity = new StringEntity(_requestContent);
			request.setEntity(strEntity);
			response = client.execute(request);
		} catch (Exception e) {
			e.getMessage();
		}
		return response;
	}
}
