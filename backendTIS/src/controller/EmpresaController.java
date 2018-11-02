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
	public JSONObject sendRoute(String route, JSONObject data) {
		JSONObject result = new JSONObject();
		
		if(route.startsWith("/add")) {			
			try {
				this.add(data);
				result.put("message", "O registro foi salvo com sucesso !");
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else if(route.startsWith("/getAll")) {
			result.put("empresas", this.getAll());
		}  else {
			result = null;
		}
		
		return result;
	}

	@Override
	public void add(JSONObject obj) throws Exception {
		String email = obj.getString("email"),
			   senha = obj.getString("senha"),
			   nome  = obj.getString("nome");
		
		this.empService.add(nome, email, senha);
	}
}
