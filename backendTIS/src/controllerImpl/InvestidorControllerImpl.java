package controllerImpl;

import org.json.JSONObject;

import model.Evento;
import model.Investidor;
import model.Ranking;
import model.Startup;
import service.InvestidorService;
import serviceImpl.InvestidorServiceImpl;

public class InvestidorControllerImpl extends UsuarioControllerImpl {
	private InvestidorService<Investidor, Startup, Evento, Long, Ranking<Integer>> investidorService;
	
	public InvestidorControllerImpl() {
		this.investidorService = new InvestidorServiceImpl ();
	}

	@Override
	public JSONObject add(JSONObject obj) {
		// TODO Auto-generated method stub
		return null;
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
