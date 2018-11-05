package controllerImpl;

import org.json.JSONObject;

import controller.InvestidorController;
import model.Evento;
import model.Investidor;
import model.Ranking;
import model.Startup;
import service.InvestidorService;
import serviceImpl.InvestidorServiceImpl;

public class InvestidorControllerImpl extends UsuarioControllerImpl implements InvestidorController {
	private InvestidorService<Investidor, Startup, Evento, Long, Ranking<Integer>> invService;
	
	public InvestidorControllerImpl() {
		this.invService = new InvestidorServiceImpl ();
	}

	@Override
	public JSONObject sendRoute(String route, JSONObject data) {
		JSONObject result = new JSONObject ();
		
		if(route.startsWith("/add")) {			
			this.add(data);
			result.put("", data.get("id"));
		} else if(route.startsWith("/getAll")) {
			this.getAll().toString();
		}  else {
			result = null;
		}
		
		return null;
	}
}
