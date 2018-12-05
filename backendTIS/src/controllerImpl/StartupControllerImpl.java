package controllerImpl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.AbstractUsuarioController;
import controller.StartupController;
import model.IQuestionario;
import model.Questionario;
import model.Startup;
import service.StartupService;
import serviceImpl.StartupServiceImpl;
import util.RNException;

public class StartupControllerImpl extends AbstractUsuarioController<Startup> implements StartupController {
	private StartupService<Startup, Long> stpService;
	
	public StartupControllerImpl() {
		this.userService = this.stpService = new StartupServiceImpl ();
	}

	@Override
	public JSONObject update(JSONObject obj) {
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
			this.stpService.update(stp);
			result.put("startup", stp.toJSONObject());
		} catch (RNException e) {
			result.put("RNException", e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public JSONObject delete(long id) {
		
		
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
			this.stpService.add(stp);
			result.put("startup", stp.toJSONObject());
		} catch (RNException e) {
			result.put("RNException", e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public JSONObject responderQuestionario(JSONObject obj) {
		JSONObject result = new JSONObject ();
		
		Integer totalRanking = obj.getInt("ranking");
		
		Startup stp = new Startup ();
		
		stp.getId();
		
		try {
			this.stpService.add(stp);
			result.put("startup", stp.toJSONObject());
		} catch (RNException e) {
			result.put("RNException", e.getMessage());
			e.printStackTrace();
		}
	
		return result;
	}
}
