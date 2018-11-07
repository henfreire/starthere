package util;

import org.json.JSONArray;
import org.json.JSONObject;

public interface toJSON {
	public JSONObject toJSONObject();

	public default JSONArray toJsonArray() {
		return new JSONArray().put(toJSONObject());
	}
}
