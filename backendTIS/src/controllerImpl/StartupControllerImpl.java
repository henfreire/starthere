package controllerImpl;

import org.json.JSONObject;

import controller.StartupController;
import model.Startup;
import serviceImpl.StartupServiceImpl;

public class StartupControllerImpl extends UsuarioControllerImpl<Startup> implements StartupController {
	
	public StartupControllerImpl() {
		this.service = new StartupServiceImpl ();
	}
	
	@Override
	public JSONObject sendRoute(String route, JSONObject data) {
		JSONObject result = new JSONObject ();
		
		try {
			if(route.startsWith("/add")) {			
				result = this.add(data);
			} else if(route.startsWith("/getAll")) {
				this.getAll().toString();
			}  else {
				throw new Exception("Rota inválida !");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("error", e.getMessage());
		}
		
		return result;
	}
}
