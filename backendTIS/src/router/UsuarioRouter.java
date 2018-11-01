package router;

import org.json.JSONObject;

import controller.EmpresaController;
import controller.StartupController;
import controller.InvestidorController;
import controller.Routable;

public class UsuarioRouter implements Routable {
	
	@Override
	public String sendRoute(String route, JSONObject requestData) {
		String str = null;
		Routable router = null;
		
		if(route.startsWith("/login")) {
			str = this.login(requestData);		
		} else {
			if (route.startsWith("/empresa")) {
				route = route.replaceAll("/empresa", "");
				router = new EmpresaRouter();
			} else if (route.startsWith("/startup")) {
				route = route.replaceAll("/startup", "");
				router = new StartupRouter();
			} else if (route.startsWith("/investidor")) {
				route = route.replaceAll("/investidor", "");
				router = new InvestidorRouter();
			}
			
			str = router.sendRoute(route, requestData);
		}
		
		return str;
	}

	public String login (JSONObject requestData) {
		
		EmpresaController empCtl = new EmpresaController (); 
		StartupController stpCtl = new StartupController (); 
		InvestidorController invCtl = new InvestidorController (); 
		
		JSONObject obj;
		
		obj = empCtl.getUser(empCtl.getService(), requestData);
		
		if(obj == null) {
			obj = stpCtl.getUser(stpCtl.getService(), requestData);
		} 
		
		if(obj == null) {
			obj = invCtl.getUser(invCtl.getService(), requestData);
		}
		
		return obj != null 
					? "Usuário logado !"
					: "Nenhum usuário foi encontrado !";
	}
}
