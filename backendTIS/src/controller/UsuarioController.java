package controller;

import org.json.JSONObject;

import model.Usuario;
import service.IService;

public interface UsuarioController extends basicCRUD {
	
	public default JSONObject getUser (IService service, JSONObject obj) {
		String email = obj.getString("email"),
			   senha = obj.getString("senha");

		JSONObject result = new JSONObject();
		
		Usuario user = service.buscar(email);

		if(user != null && user.getSenha().equals(senha)) {
			result.put("id", user.getId());
			result.put("nome", user.getNome());
			result.put("email", user.getEmail());
		} else {
			result = null;
		}
		
		return result;
	}	
	
	public default void add(IService service, JSONObject obj) {
		String  nome = obj.getString("nome"),
				senha = obj.getString("senha"),
				email = obj.getString("email");
		
		service.add(nome, senha, email);
	}
	
	public IService getService();
}
