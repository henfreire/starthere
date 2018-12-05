package controller;

import org.json.JSONObject;

public interface LoginController extends Routable {	
	public JSONObject login(JSONObject requestData);
}
