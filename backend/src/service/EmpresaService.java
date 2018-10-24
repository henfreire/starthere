package service;

import java.util.ArrayList;
import java.util.List;

import model.Empresa;
import model.Usuario;

public class EmpresaService implements UsuarioService {

	private static List<Empresa> empresas;
	
	public EmpresaService() {
		EmpresaService.empresas = new ArrayList<Empresa> ();
	}
	
	@Override
	public void add(String nome, String email, String senha) {
		Empresa newEmp = new Empresa(nome, senha, email);
		EmpresaService.empresas.add(EmpresaService.empresas.size(), newEmp);
	}

	@Override
	public void delete(long id) {
		
	}

	@Override
	public Usuario buscar(String nome) {
		return null;
	}

	@Override
	public Usuario buscar(long id) {
		return null;
	}

	public List<Empresa> getAll() {
		return this.empresas;
	}

}
