package controller;

import org.json.JSONObject;

public interface EmpresaController extends UsuarioController {
	public JSONObject addEvento(JSONObject obj);
}
