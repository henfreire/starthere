package service;

import model.Usuario;

public interface UsuarioService {
	public void add(String nome, String email, String senha) throws Exception;
	public Usuario delete(long id) throws Exception;
	public Usuario buscar(String nome) throws Exception;
	public Usuario buscar(long id);
}
