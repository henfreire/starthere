package service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.json.JSONArray;

import com.google.gson.JsonArray;

import model.Empresa;
import model.Usuario;

public class EmpresaService implements UsuarioService {

	private static List<Empresa> empresas = new ArrayList<Empresa> ();
	
	public EmpresaService() {}
	
	@Override
	public void add(String nome, String email, String senha) {
		Empresa newEmp = new Empresa(nome, senha, email);
		EmpresaService.empresas.add(newEmp);
	}

	@Override
	public void delete(long id) {
		// not implemented yet.
	}

	@Override
	public Usuario buscar(String email) {
		for(int i = 0; i < this.empresas.size() ; i++) {
			Usuario user = this.empresas.get(i);
			if(email.equals(user.getEmail())) {
				return user;
			}
		}
		
		return null;
	}

	@Override
	public Usuario buscar(long id) {
		// not implemented yet.
		return null;
	}

	public List<Empresa> getAll() {
		return EmpresaService.empresas;
	}

}
