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
	
	@Override
	public JSONArray getAll() {
		JSONArray aux = new JSONArray ();
		List <Empresa> empresas = this.empService.getAll();
		
		JOptionPane.showMessageDialog(null, empresas.get(0).toString());
		
		for(int i = 0 ;  i < empresas.size() ; i++ ) {
			aux.put(empresas.get(i).toJSONObject());
		}

		JOptionPane.showMessageDialog(null, aux.toString());
		
		return aux;
	}

	@Override
	public void add(JSONObject obj) {
		String  nome = obj.getString("nome"),
				senha = obj.getString("senha"),
				email = obj.getString("email");
		
		this.empService.add(nome, senha, email);
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
}
