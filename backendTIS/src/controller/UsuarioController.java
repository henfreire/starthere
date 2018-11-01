package controller;

import org.json.JSONObject;

public interface UsuarioController extends Routable {
	
	public default void add(JSONObject obj) {
		String  nome = obj.getString("nome"),
				senha = obj.getString("senha"),
				email = obj.getString("email");
	}
}
