package service;

import model.Usuario;

public interface IService {
	public Usuario buscar(String nome);
	public void add(String nome, String email, String senha) throws Exception;
}
