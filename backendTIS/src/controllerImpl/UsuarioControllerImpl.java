package controllerImpl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.UsuarioController;

import service.UsuarioService;
import util.RNException;
import model.Usuario;

public abstract class UsuarioControllerImpl<E extends Usuario> implements UsuarioController {
	protected UsuarioService<E, Long> service; 
	
	public JSONArray getAll() {	
		JSONArray aux = new JSONArray ();
		List<E> usuarios;
		try {
			usuarios = (List<E>) this.service.getAll();
			usuarios.stream()
					.forEach(emp -> aux.put( emp.toJSONObject()) );
		} catch (RNException e) {
			e.printStackTrace();
		}
		
		return aux;
	}
	
	public JSONObject delete(Long id) {
		JSONObject result = new JSONObject();
		E user;
		try {
			user = (E) this.service.delete(id);
			result.append("usuario", user);
		} catch (RNException e) {
			result.append("RNError", e.getMessage());
		}
		
		return result;
	}

	public JSONObject get(JSONObject obj){
		JSONObject result = new JSONObject();
		String email = obj.getString("email");
		
		E user;
		try {
			user = (E) this.service.getUsuarioByEmail(email);
			
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
		
		E user = (E) new Usuario(nome, email);
		user.setSenha(senha);
		
		try {
			this.service.add(user);
			result.append("user", user.toJSONObject());
		} catch (RNException e) {
			e.printStackTrace();
			result.put("error", e.getMessage());
		}
		
		return result;
	}

	@Override
	public JSONObject update(JSONObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
