package service;

import model.Usuario;

public interface UsuarioService extends IService {
	public void add(String nome, String email, String senha) throws Exception;
	public void delete(long id);
	public Usuario buscar(String nome);
	public Usuario buscar(long id);
}
