package controllerImpl;

import org.json.JSONObject;

import serviceImpl.StartupServiceImpl;

public class StartupControllerImpl  {
	public StartupServiceImpl stpService;
	
	public StartupControllerImpl() {
		stpService = new StartupServiceImpl ();
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
