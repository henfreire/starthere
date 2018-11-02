package controller;

import org.json.JSONObject;

import model.Usuario;
import service.UsuarioService;

public class LoginController implements Routable {
	
	public JSONObject getUser (UsuarioService service, JSONObject obj) throws Exception {
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

	@Override
	public JSONObject sendRoute(String route, JSONObject requestData) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	public String login (JSONObject requestData) {
		
		JSONObject obj = null;
		
//		obj = empCtl.getUser(empCtl.getService(), requestData);
//		
//		if(obj == null) {
//			obj = stpCtl.getUser(stpCtl.getService(), requestData);
//		} 
//		
//		if(obj == null) {
//			obj = invCtl.getUser(invCtl.getService(), requestData);
//		}
		
		return obj != null 
					? "Usu�rio logado !"
					: "Nenhum usu�rio foi encontrado !";
	}
	
	
	
	
}
