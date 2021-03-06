package com.vooc.Pages;

import java.io.InputStream;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;

import com.vooc.Utils.ConvertType;
import com.vooc.Utils.Logger;
import com.vooc.Utils.TxtFile;
import com.voov.Api.HandleApi;

public class CommonApi extends HandleApi {
	HttpResponse response = null;
	String token = null;
	JSONObject jo = null;
	Logger log = new Logger();

	public void CallApiWithUri(String type, String apiUri) {
		if (type.toUpperCase().equals("GET")) {
			response = null;
			response = ExecuteRequestGetMethodToUri(apiUri);
		}
		if (type.toUpperCase().equals("POST")) {
			response = null;
			response = ExecuteRequestPostMethodToUri(apiUri);
		}
		GetResponseContent();
	}

	public void CallApiWithUriToken(String type, String apiUri) {
		String bearerToken = "Bearer " + TxtFile.ExecuteReadToken();
		if (type.toUpperCase().equals("GET")) {
			response = null;
			response = ExecuteRequestGetMethodToUriWithToken(apiUri, bearerToken);
		}
		if (type.toUpperCase().equals("POST")) {
			response = null;
			response = ExecuteRequestPostMethodToUriWithToken(apiUri, bearerToken);
		}
		GetResponseContent();
	}

	public void CallApiWithUriHaveParams(String apiUri, List<List<String>> params) {
		String bearerToken = "Bearer " + TxtFile.ExecuteReadToken();
		response = null;
		response = ExecuteRequestGetMethodToUriHaveParams(apiUri, params, bearerToken);
		GetResponseContent();
	}

	public void CheckStatusResponse(String sts) {
		int actSts = response.getStatusLine().getStatusCode();
		int expSts = Integer.parseInt(sts);
		log.Info("Status acutal " + actSts + " Status expected " + expSts);
		Assert.assertTrue(actSts == expSts);
	}

	public void CheckHeaderResponse(List<List<String>> listHeader) {
		for (int i = 0; i < listHeader.get(0).size(); i++) {
			String actHeader = null;
			Header[] _header = response.getHeaders(listHeader.get(0).get(i));
			for (int j = 0; j < _header.length; j++) {
				actHeader = _header[j].toString();
				log.Info("Header Response actual: " + actHeader);
			}
			String expHeader = listHeader.get(0).get(i) + ": " + listHeader.get(1).get(i);
			log.Info("Header Response expected: " + expHeader);
			Assert.assertTrue(actHeader.equals(expHeader));
		}
	}

	public void CheckContentResponse(String key, List<List<String>> listContent) {
		try {
			if (key.toUpperCase().equals("NOT YET")) {
				for (int i = 0; i < listContent.get(0).size(); i++) {
					Object val = jo.get(listContent.get(0).get(i));
					String actContent = ConvertType.ConvertStringToUTF8(val.toString());
					if (actContent == null) {
						Assert.assertNotNull(actContent);
					}
					String expContent = listContent.get(1).get(i);
					log.Info("Body Response actual: " + actContent);
					log.Info("Body Response expected: " + expContent);
					Assert.assertTrue(actContent.equals(expContent));
				}
			} else {
				Object KeyObj = (Object) jo.get(key);
				if (KeyObj == null) {
					Assert.assertNotNull(KeyObj);
				}
				if (KeyObj instanceof JSONArray) {
					JSONArray ja = (JSONArray) KeyObj;
					JSONObject josj = null;
					for (int i = 0; i < ja.size(); i++) {
						josj = (JSONObject) ja.get(i);
						for (int j = 0; j < listContent.get(0).size(); j++) {
							Object val = josj.get(listContent.get(0).get(j));
							String actContent = ConvertType.ConvertStringToUTF8(val.toString());
							if (actContent == null) {
								Assert.assertNotNull(actContent);
							}
							String expContent = listContent.get(i + 1).get(j);
							log.Info("Body Response actual: " + actContent);
							log.Info("Body Response expected: " + expContent);
							Assert.assertTrue(actContent.equals(expContent));
						}
					}
				} else {
					JSONObject jobj = (JSONObject) KeyObj;
					for (int i = 0; i < listContent.get(0).size(); i++) {
						Object val = jobj.get(listContent.get(0).get(i));
						String actContent = ConvertType.ConvertStringToUTF8(val.toString());
						if (actContent == null) {
							Assert.assertNotNull(actContent);
						}
						String expContent = listContent.get(1).get(i);
						log.Info("Body Response actual: " + actContent);
						log.Info("Body Response expected: " + expContent);
						Assert.assertTrue(actContent.equals(expContent));
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	public void GetResponseContent() {
		HttpEntity _entity = response.getEntity();
		if (_entity != null) {
			InputStream strResponse;
			try {
				strResponse = _entity.getContent();
				String result = ConvertType.convertStreamToString(strResponse);
				Object obj = new JSONParser().parse(result);
				jo = (JSONObject) obj;
				if (jo.get("token") != null) {
					token = jo.get("token").toString();
					TxtFile.ExecuteWriteToken(token);
					log.Info("Token is [" + token + "]");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
