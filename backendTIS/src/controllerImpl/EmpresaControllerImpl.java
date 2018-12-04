package controllerImpl;

import org.json.JSONObject;

import serviceImpl.EmpresaServiceImpl;
import service.EmpresaService;

import model.Empresa;
import model.Startup;
import model.Evento;

public class EmpresaControllerImpl extends UsuarioControllerImpl {	
	private EmpresaService<Empresa, Startup, Evento, Long> empresaService;
	
	public EmpresaControllerImpl () {
		this.empresaService = new EmpresaServiceImpl ();
	}
	
	@Override
	public JSONObject sendRoute(String route, JSONObject data) {
		JSONObject result = new JSONObject();
		
		try {
//			if(route.startsWith("/add")) {							
//				result = this.add(data);
//			} else if(route.startsWith("/get")) {
//				result.put("empresas", this.get(data));
//			} else if(route.startsWith("/getAll")) {
//				result.put("empresas", this.getAll());
//			} else {
				return this.sendRoute(route, data);
//			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("error", e.getMessage());
		}
			
		return result;
	}

	@Override
	public JSONObject add(JSONObject obj) {
		return null;
	}

	@Override
	public JSONObject update(JSONObject obj) {
		return null;
	}

	@Override
	public JSONObject delete(long id) {
		return null;
	}
}
