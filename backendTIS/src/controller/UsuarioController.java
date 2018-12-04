package controller;

import org.json.JSONObject;

public interface UsuarioController extends CRUDRoutableController {
	public JSONObject login(JSONObject requestData);
}
