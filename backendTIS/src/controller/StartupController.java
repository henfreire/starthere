package controller;

import org.json.JSONObject;

public interface StartupController extends Routable {
	public JSONObject responderQuestionario(JSONObject obj); 
}
