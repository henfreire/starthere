package controller;

import org.json.JSONArray;
import org.json.JSONObject;

import service.IService;
import service.InvestidorService;
import service.StartupService;

public class InvestidorController implements UsuarioController {
	private InvestidorService invService;
	
	public InvestidorController() {
		invService = new InvestidorService ();
	}
	@Override
	public JSONObject delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject get(JSONObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public IService getService() {
		return this.invService;
	}	

}
