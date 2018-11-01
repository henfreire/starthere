package controller;

import service.EmpresaService;

import java.util.List;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Empresa;
import model.Usuario;

public class EmpresaController implements UsuarioController {
	private EmpresaService empService;
	
	public EmpresaController() {
		this.empService = new EmpresaService ();
	}
	
	public JSONArray getAll() {
		JSONArray aux = new JSONArray ();
		List <Empresa> empresas = this.empService.getAll();
		
		for(int i = 0 ;  i < empresas.size() ; i++ ) {
			aux.put(empresas.get(i).toJSONObject());
		}

		JOptionPane.showMessageDialog(null, aux.toString());
		
		return aux;
	}
	
	public JSONObject delete(long id) {
		return null;
	}

	public JSONObject get(JSONObject obj) throws Exception {
		String email = obj.getString("email");
		JSONObject result = new JSONObject();
		
		Usuario user = this.empService.buscar(email);
		
		result.put("id", user.getId());
		result.put("nome", user.getNome());
		result.put("email", user.getEmail());
		
		return result;
	}
	
	@Override
	public String sendRoute(String route, JSONObject data) {
		String result = null;
		
		if(route.startsWith("/add")) {			
			try {
				this.add(data);
				result = "O registro foi salvo com sucesso !";
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else if(route.startsWith("/getAll")) {
			result = this.getAll().toString();
		}  else {
			result = null;
		}
		
		return result;
	}
}
