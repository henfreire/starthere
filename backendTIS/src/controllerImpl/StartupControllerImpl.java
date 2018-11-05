package controllerImpl;

import org.json.JSONObject;

import controller.StartupController;
import serviceImpl.StartupServiceImpl;

public class StartupControllerImpl extends UsuarioControllerImpl implements StartupController {
	public StartupServiceImpl stpService;
	
	public StartupControllerImpl() {
		stpService = new StartupServiceImpl ();
	}
	
	@Override
	public JSONObject sendRoute(String route, JSONObject data) {
		JSONObject result = new JSONObject ();
		
		if(route.startsWith("/add")) {			
			try {
				this.add(data);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else if(route.startsWith("/getAll")) {
			result.put("", this.getAll().toString());
		}  else {
			result = null;
		}
		
		return result;
	}
}
