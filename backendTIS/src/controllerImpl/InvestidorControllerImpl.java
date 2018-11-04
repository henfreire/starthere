package controllerImpl;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.InvestidorController;
import serviceImpl.InvestidorServiceImpl;

public class InvestidorControllerImpl implements InvestidorController {
	private InvestidorServiceImpl invService;
	
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
}
