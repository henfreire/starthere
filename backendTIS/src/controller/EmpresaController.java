package controller;

import service.EmpresaService;
import service.IService;

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
	
	@Override
	public JSONArray getAll() {
		JSONArray aux = new JSONArray ();
		List <Empresa> empresas = this.empService.getAll();
		
		for(int i = 0 ;  i < empresas.size() ; i++ ) {
			aux.put(empresas.get(i).toJSONObject());
		}

		JOptionPane.showMessageDialog(null, aux.toString());
		
		return aux;
	}
	
	@Override
	public JSONObject delete(long id) {
		return null;
	}

	@Override
	public JSONObject get(JSONObject obj) {
		String email = obj.getString("email");
		JSONObject result = new JSONObject();
		
		Usuario user = this.empService.buscar(email);
		
		result.put("id", user.getId());
		result.put("nome", user.getNome());
		result.put("email", user.getEmail());
		
		return result;
	}

	@Override
	public IService getService() {
		return this.empService;
	}	
}
