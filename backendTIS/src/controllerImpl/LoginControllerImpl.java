package controllerImpl;

import org.json.JSONObject;

import controller.LoginController;
import model.Usuario;
import service.LoginService;
import serviceImpl.UsuarioServiceImpl;
import util.RNException;

public class LoginControllerImpl implements LoginController {
	
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
