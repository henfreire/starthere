package router;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.json.JSONObject;

import controller.UsuarioController;

public class UsuarioRouter implements Routable {
	
	@Override
	public String sendRoute(String route, JSONObject requestData) {
		Routable router = null;
		
		if (route.startsWith("/empresa")) {
			route = route.replaceAll("/empresa", "");
			router = new EmpresaRouter();
		} else if (route.startsWith("/startup")) {
			route = route.replaceAll("/startup", "");
			router = new StartUpRouter();
		} else if (route.startsWith("/investidor")) {
			route = route.replaceAll("/investidor", "");
			router = new InvestidorRouter();
		} else if (route.startsWith("/get")) {
			route = route.replaceAll("/get", "");
			router = new InvestidorRouter();
		} 
		
		return router.sendRoute(route, requestData);
	}
}
