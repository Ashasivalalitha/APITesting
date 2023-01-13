package utilities;

import org.json.JSONObject;

import listeners.ExtentListeners;

public class TestUtils {
	
	
	public static Boolean hasKey(String json, String key) {
		JSONObject jsonObject = new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating the presence of '"+key+"': "+jsonObject.has(key));
		return jsonObject.has(key);
		
	}
	
	
	
	public static String getKeyValue(String json, String key) {
		JSONObject jsonObject = new JSONObject(json);
		ExtentListeners.testReport.get().info("Value of '"+key+"': "+jsonObject.get(key).toString());
		return jsonObject.get(key).toString();
	}
	
	
	

}
