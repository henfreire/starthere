package controllerImpl;

import java.util.List;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.EmpresaController;
import model.Empresa;
import model.Usuario;
import serviceImpl.EmpresaServiceImpl;
import util.RNException;

public class EmpresaControllerImpl extends UsuarioControllerImpl implements EmpresaController {
	private EmpresaServiceImpl empService;
	
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
