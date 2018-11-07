package controller;

import org.json.JSONArray;
import org.json.JSONObject;

public interface CRUDController {
	public JSONObject add(JSONObject obj);
	public JSONObject update(JSONObject obj);
	public JSONObject delete(long id);
	public JSONObject get(JSONObject obj);
	public JSONArray getAll();
}
