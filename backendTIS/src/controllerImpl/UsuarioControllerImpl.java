package controllerImpl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.UsuarioController;

import service.UsuarioService;
import util.RNException;
import model.Usuario;

public abstract class UsuarioControllerImpl implements UsuarioController {
	UsuarioService<Usuario, Long> service; 
	
	public JSONArray getAll() {	
		JSONArray aux = new JSONArray ();
		List<Usuario> usuarios;
		try {
			usuarios = this.service.getAll();
			usuarios.stream()
					.forEach(emp -> aux.put( emp.toJSONObject()) );
		} catch (RNException e) {
			e.printStackTrace();
		}
		
		return aux;
	}
	
	public JSONObject delete(Long id) {
		JSONObject result = new JSONObject();
		Usuario user;
		try {
			user = this.service.delete(id);
			result.append("usuario", user);
		} catch (RNException e) {
			result.append("RNError", e.getMessage());
		}
		
		return result;
	}

	public JSONObject get(JSONObject obj){
		JSONObject result = new JSONObject();
		String email = obj.getString("email");
		
		Usuario user;
		try {
			user = this.service.getUsuarioByEmail(email);
			
			result.put("id", user.getId());
			result.put("nome", user.getNome());
			result.put("email", user.getEmail());
			
		} catch (RNException e) {
			result.put("RNException", e.getMessage());
		}
		
		return result;
	}

	public JSONObject add(JSONObject obj) {
		JSONObject result = new JSONObject();
		String email = obj.getString("email"),
			   senha = obj.getString("senha"),
			   nome  = obj.getString("nome");
		
		Usuario user = new Usuario(nome, email);
		user.setSenha(senha);
		
		try {
			this.service.add(user);
			result.append("newUsuario", user);
		} catch (RNException e) {
			result.put("RNException", e.getMessage());
		}
		
		return result;
	}
}
