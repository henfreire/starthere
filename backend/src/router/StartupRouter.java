package router;

import javax.swing.JOptionPane;

import org.json.JSONObject;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;

import controller.EmpresaController;
import controller.StartupController;

public class StartupRouter implements Routable {
	private StartupController stpController;
	
	public StartupRouter () {
		this.stpController = new StartupController ();
	}
	
	@Override
	public String sendRoute(String route, JSONObject data) {
		String result = null;
		
		JOptionPane.showMessageDialog(null, route);
		
		if(route.startsWith("/add")) {			
			try {
				this.stpController.add(this.stpController.getService(), data);
				result = "O registro foi salvo com sucesso !";
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else if(route.startsWith("/getAll")) {
			result = this.stpController.getAll().toString();
		}  else {
			result = null;
		}
		
		return result;
	}

}
