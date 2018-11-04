package controllerImpl;

import org.json.JSONObject;

import controller.LoginController;
import model.Usuario;
import serviceImpl.EmpresaServiceImpl;
import serviceImpl.InvestidorServiceImpl;
import serviceImpl.StartupServiceImpl;
import serviceImpl.UsuarioServiceImpl;
import util.RNException;

public class LoginControllerImpl implements LoginController {
	
	@Override
	public JSONObject sendRoute(String route, JSONObject requestData) {
		JSONObject result = new JSONObject();
		
		if(route.equals("/login")) {
			result = login(requestData);
		}
		
		return result;
	}
	
	public JSONObject login (JSONObject requestData) {
		JSONObject result = new JSONObject();
		Usuario usr = null;
		UsuarioServiceImpl<? extends Usuario> service;
		
		String email = requestData.getString("email"),
			   senha = requestData.getString("senha");

		service = new EmpresaServiceImpl();
		
		try {
			usr = service.auth(email, senha);
		

			if(usr == null) {
				service = new StartupServiceImpl();
				usr = service.auth(email, senha);
			}
			
			if(usr == null) {
				service = new InvestidorServiceImpl();
				usr = service.auth(email, senha);
			}
			
			if(usr == null) {
				throw new RNException("Credenciais Inválidas !");
			} else {
				result = new JSONObject();
				result.append("user", usr.getId());
			}
		} catch (RNException e) {
			result.append("RNException", e.getMessage());
		}
			
		return result;
	}
}
