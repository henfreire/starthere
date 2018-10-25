package router;

import org.json.JSONObject;

import controller.EmpresaController;

public class EmpresaRouter implements Routable {
	private EmpresaController empController;
	
	public EmpresaRouter () {
		this.empController = new EmpresaController ();
	}
	
	@Override
	public String sendRoute(String route, JSONObject data) {
		String result = null;
		
		if(route.startsWith("/add")) {			
			try {
				this.empController.add(this.empController.getService(), data);
				result = "O registro foi salvo com sucesso !";
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else if(route.startsWith("/getAll")) {
			result = this.empController.getAll().toString();
		}  else {
			result = null;
		}
		
		return result;
	}
}
