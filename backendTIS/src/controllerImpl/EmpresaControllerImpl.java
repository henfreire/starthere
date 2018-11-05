package controllerImpl;

import org.json.JSONObject;

import model.Empresa;
import model.Evento;
import model.Startup;

import controller.EmpresaController;

import service.EmpresaService;
import serviceImpl.EmpresaServiceImpl;

public class EmpresaControllerImpl extends UsuarioControllerImpl implements EmpresaController {
	private EmpresaService<Empresa, Startup, Evento, Long> empService;
	
	public EmpresaControllerImpl () {
		this.empService = new EmpresaServiceImpl ();
	}
	
	@Override
	public JSONObject sendRoute(String route, JSONObject data) {
		JSONObject result = new JSONObject();
		
		try {
			if(route.startsWith("/add")) {			
				this.add(data);
				result.put("empresa", data);
			} else if(route.startsWith("/get")) {
				result.put("empresas", this.get(data));
			} else if(route.startsWith("/getAll")) {
				result.put("empresas", this.getAll());
			} else if(route.startsWith("/getAll")) {
				result.put("empresas", this.getAll());
			} else {
				throw new Exception("Rota inválida !");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("error", e.getMessage());
		}
			
		return result;
	}

}
