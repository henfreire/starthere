package service;

import model.Usuario;

public interface UsuarioService {
	public void add(String nome, String email, String senha);
	public void delete(long id);
	public Usuario buscar(String nome);
	public Usuario buscar(long id);
}
