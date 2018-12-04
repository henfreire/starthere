package controllerImpl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.UsuarioController;

import service.LoginService;
import service.UsuarioService;

import serviceImpl.UsuarioServiceImpl;

import util.RNException;

import model.Usuario;

public abstract class UsuarioControllerImpl implements UsuarioController {
	protected UsuarioService<Usuario, Long> userService; 
	
	public UsuarioControllerImpl () {
		this.userService = new UsuarioServiceImpl();
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

//	@Override
//	public JSONObject update(JSONObject obj) {
//		return null;
//	}
//	
//	@Override
//	public JSONObject delete(long id) {
//		return null;
//	}

	@Override
	public JSONObject login(JSONObject requestData) {
		JSONObject result = new JSONObject();
		Usuario usr = null;
		LoginService <Usuario> service;
		
		String email = requestData.getString("email"),
			   senha = requestData.getString("senha");

		service = new UsuarioServiceImpl(); 
				
		try {
			usr = service.login(email, senha);
			
			if(usr == null) {
				throw new RNException("Credenciais Inválidas !");
			} else {
				usr.setSenha(null);
				result = new JSONObject();
				result.put("user", usr.toJSONObject());
			}
		} catch (RNException e) {
			result.append("RNException", e.getMessage());
		}
		
		
		return result;
	}
	
}
