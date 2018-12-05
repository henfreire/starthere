package controllerImpl;

import org.json.JSONObject;

import controller.AbstractUsuarioController;
import model.Startup;
import service.StartupService;
import serviceImpl.StartupServiceImpl;
import util.RNException;

public class StartupControllerImpl extends AbstractUsuarioController<Startup> {
	private StartupService<Startup, Long> stpService;
	
	public StartupControllerImpl() {
		this.userService = this.stpService = new StartupServiceImpl ();
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
	
	@Override
	public JSONObject add(JSONObject obj) {
		JSONObject result = new JSONObject ();
		
		String nome, email, senha;
	
		nome = obj.getString("nome");
		senha = obj.getString("senha");
		email = obj.getString("email");
		
		Startup stp = new Startup ();
		
		stp.setNome(nome);
		stp.setEmail(email);
		stp.setSenha(senha);
		
		try {
			this.userService.add(stp);
			result.put("startup", stp.toJSONObject());
		} catch (RNException e) {
			result.put("RNException", e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}

}
