package controller;

import org.json.JSONArray;
import org.json.JSONObject;

public interface basicCRUD {
	public void add(JSONObject obj);
	public JSONObject delete(long id);
	public JSONObject get(JSONObject obj);
	public JSONArray getAll();
}
