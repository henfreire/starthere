package controller;

import org.json.JSONObject;

public interface Routable {
	public String sendRoute(String route, JSONObject requestData);	
}
