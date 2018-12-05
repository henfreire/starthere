package controllerImpl;

import org.json.JSONObject;

import controller.AbstractUsuarioController;
import model.IQuestionario;
import model.Investidor;
import model.Startup;
import service.InvestidorService;
import serviceImpl.InvestidorServiceImpl;
import util.RNException;

public class InvestidorControllerImpl extends AbstractUsuarioController<Investidor> {
	private InvestidorService<Investidor, Startup, Long, IQuestionario<String>> investidorService;
	
	public InvestidorControllerImpl() {
		this.userService = 
		this.investidorService = new InvestidorServiceImpl ();
	}

	@Override
	public JSONObject add(JSONObject obj) {
		JSONObject result = new JSONObject ();
		
		String nome, email, senha;
	
		nome = obj.getString("nome");
		senha = obj.getString("senha");
		email = obj.getString("email");
		
		Investidor inv = new Investidor ();
		
		inv.setNome(nome);
		inv.setEmail(email);
		inv.setSenha(senha);
		
		try {
			this.investidorService.add(inv);
			result.put("investidor", inv.toJSONObject());
		} catch (RNException e) {
			result.put("RNException", e.getMessage());
			e.printStackTrace();
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
