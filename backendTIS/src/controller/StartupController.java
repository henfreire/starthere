package controller;

import org.json.JSONArray;
import org.json.JSONObject;

import service.StartupService;

public class StartupController implements UsuarioController {
	public StartupService stpService;
	
	public StartupController() {
		stpService = new StartupService ();
	}

	public JSONObject delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public JSONObject get(JSONObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public JSONArray getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject sendRoute(String route, JSONObject data) {
		String result = null;
		
		if(route.startsWith("/add")) {			
			try {
//				this.add(this.getService(), data);
				result = "O registro foi salvo com sucesso !";
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else if(route.startsWith("/getAll")) {
			result = this.getAll().toString();
		}  else {
			result = null;
		}
		
		return null;
	}

	@Override
	public void add(JSONObject obj) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
