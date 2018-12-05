package controller;

import org.json.JSONObject;

public interface EmpresaController extends CRUDRoutableController {
	public JSONObject addEvento(JSONObject obj);
}
