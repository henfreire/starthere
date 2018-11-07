package controller;

import org.json.JSONObject;

public interface Routable {
	public JSONObject sendRoute(String route, JSONObject requestData);	
}
