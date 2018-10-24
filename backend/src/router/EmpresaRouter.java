package router;

import javax.swing.JOptionPane;

import org.json.JSONObject;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;

import com.google.gson.JsonObject;

import controller.EmpresaController;

public class EmpresaRouter implements Routable {
	private EmpresaController empController;
	
	public EmpresaRouter () {
		this.empController = new EmpresaController ();
	}
	
	@Override
	public String sendRoute(String route, JSONObject data) {
		String result = null;
		
		JOptionPane.showMessageDialog(null, route);
		
		if(route.startsWith("/add")) {			
			try {
				this.empController.add(data);
				result = "O registro foi salvo com sucesso !";
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else if(route.startsWith("/getAll")) {
			result = this.empController.getAll().toString();
		} else if(route.startsWith("/evento")) {
			EventoRouter e = new EventoRouter(); 
			result = this.empController.getAll().toString();
		} else {
			result = null;
		}
		
		return result;
	}

}
