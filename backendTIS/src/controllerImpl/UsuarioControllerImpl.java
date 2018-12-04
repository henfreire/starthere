package controllerImpl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.UsuarioController;

import service.UsuarioService;

import serviceImpl.UsuarioServiceImpl;

import util.RNException;

import model.Usuario;

public abstract class UsuarioControllerImpl implements UsuarioController {
	protected UsuarioService<Usuario, Long> userService; 
	
	public UsuarioControllerImpl () {
		this.userService = new UsuarioServiceImpl();
	}
	
	@Override
	public JSONObject sendRoute(String route, JSONObject data) {
		JSONObject result = new JSONObject ();
		
		try {
			if(route.startsWith("/add")) {							
				result = this.add(data);
			} else if(route.startsWith("/update")) {
				result.put("usuario", this.update(data));
			} else if(route.startsWith("/get")) {
				result.put("usuario", this.get(data));
			} else if(route.startsWith("/getAll")) {
				result.put("usuarios", this.getAll());
			} else if(route.startsWith("/get")) {
				result.put("usuario", this.get(data));
			} 
		} catch (Exception e) {
			e.printStackTrace();
			result.put("error", e.getMessage());
		}
		
		return result;
	}
	
	public JSONObject getAll() {	
		JSONObject aux = new JSONObject ();
		JSONArray usuariosJSON = new JSONArray();
		
		List<Usuario> usuarios;
		try {
			usuarios = this.userService.getAll();
			usuarios.stream()
					.forEach(emp -> usuariosJSON.put( emp.toJSONObject()) );
			
			aux.put("usuarios", usuariosJSON);
		} catch (RNException e) {
			e.printStackTrace();
			aux.put("RNException", e.getMessage());
		}
		
		return aux;
	}
	
//	public JSONObject delete(Long id) {
//		JSONObject result = new JSONObject();
//		Usuario user;
//		try {
//			user = this.userService.delete(id);
//			result.append("usuario", user);
//		} catch (RNException e) {
//			result.append("RNException", e.getMessage());
//		}
//		
//		return result;
//	}
//
	public JSONObject get(JSONObject obj){
		JSONObject result = new JSONObject();
		String email = obj.getString("email");
		
		Usuario user;
		try {
			user = this.userService.getUsuarioByEmail(email);
			
			result.put("id", user.getId());
			result.put("nome", user.getNome());
			result.put("email", user.getEmail());
			
		} catch (RNException e) {
			result.put("RNException", e.getMessage());
		}
		
		return result;
	}
	
	
//
//	public JSONObject add(JSONObject obj) {
//		JSONObject result = new JSONObject();
//		String email = obj.getString("email"),
//			   senha = obj.getString("senha"),
//			   nome  = obj.getString("nome");
//		
//		Usuario user = new Usuario();
//
//		user.setNome(nome);
//		user.setEmail(email);
//		user.setSenha(senha);
//		
//		try {
//			this.userService.add(user);
//			result.append("user", user.toJSONObject());
//		} catch (RNException e) {
//			e.printStackTrace();
//			result.put("RNException", e.getMessage());
//		}
//		
//		return result;
//	}
//
//	@Override
//	public JSONObject update(JSONObject obj) {
//		return null;
//	}
//	
//	@Override
//	public JSONObject delete(long id) {
//		return null;
//	}	
}
