package controllerImpl;

import org.json.JSONObject;

import controller.LoginController;
import model.IUsuario;

import service.LoginService;
import serviceImpl.LoginServiceImpl;

import util.RNException;

public class LoginControllerImpl implements LoginController {
	
	@Override
	public JSONObject login(JSONObject requestData) {
		JSONObject result = new JSONObject();
		IUsuario usr = null;
		LoginService <IUsuario> service = new LoginServiceImpl(); 
		
		String email = requestData.getString("email"),
			   senha = requestData.getString("senha");
				
		try {
			usr = service.login(email, senha);
			
			usr.setSenha(null);
			result = new JSONObject();
			result.put("user", usr.toJSONObject());
			
		} catch (RNException e) {
			result.put("RNException", e.getMessage());
		}
		
		return result;
	}

	@Override
	public JSONObject sendRoute(String route, JSONObject requestData) {
		return this.login(requestData);
	}
}
