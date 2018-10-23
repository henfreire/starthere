package service;

import java.util.List;

import model.Empresa;
import model.Usuario;

public class EmpresaServiceImpl implements UsuarioService {

	private static List<Empresa> empresas;
	
	@Override
	public void add(String nome, String email, String senha) {
		Empresa newEmp = new Empresa(nome, senha, email);
		this.empresas.add(0, newEmp);
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

}
