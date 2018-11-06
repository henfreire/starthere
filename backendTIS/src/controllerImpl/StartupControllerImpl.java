package controllerImpl;

import org.json.JSONObject;

import controller.StartupController;
import model.Startup;
import serviceImpl.StartupServiceImpl;

public class StartupControllerImpl extends UsuarioControllerImpl<Startup> implements StartupController {
	public StartupServiceImpl stpService;
	
	public StartupControllerImpl() {
		this.service = this.stpService = new StartupServiceImpl ();
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
			result.put("error", "Essa rota não existe para as Startups !");
		}
		
		return result;
	}
}
