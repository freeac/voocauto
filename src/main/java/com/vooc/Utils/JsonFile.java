package com.vooc.Utils;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFile {
	public static String jsonPath = "";
	public static Object obj = null;

	@SuppressWarnings("unchecked")
	public static String FindValueByKey(String pageName, String key, String type) {
		String val = "";
		String k = "";
		String v = "";
		String sourcePath = System.getProperty("user.dir");
		jsonPath = sourcePath + "\\src\\main\\Interface\\" + pageName + ".json";

		try {
			obj = new JSONParser().parse(new FileReader(jsonPath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jo = (JSONObject) obj;
		Map<String, String> app = ((Map<String, String>) jo.get(key));
		for (Map.Entry<String, String> entry : app.entrySet()) {
			k = entry.getKey();
			v = entry.getValue();
			if (k.equals(type)) {
				break;
			}
		}
		val = ConvertType.ConvertStringToUTF8(v);
		return val;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, String> GetHeader(String pageName) {
		Map<String, String> map = new HashMap<String, String>();
		String sourcePath = System.getProperty("user.dir");
		jsonPath = sourcePath + "\\src\\main\\apiRef\\" + pageName + ".json";
		try {
			obj = new JSONParser().parse(new FileReader(jsonPath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jo = (JSONObject) obj;
		map = ((Map<String, String>) jo.get("Header"));
		return map;
	}
	
	public static String GetBodyContent(String pageName) {
		String sourcePath = System.getProperty("user.dir");
		jsonPath = sourcePath + "\\src\\main\\apiRef\\" + pageName + ".json";
		try {
			obj = new JSONParser().parse(new FileReader(jsonPath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jo = (JSONObject) obj;
		String content = jo.get("Params").toString();
		return content;
	}
}
