package service;

import util.RNException;

public interface UsuarioService<Usr, Key> extends CRUDService<Usr, Key> {
	public Usr getUsuario(Key id) throws RNException;
	public Usr getUsuarioByEmail(String nome) throws RNException;
	public Usr autenticar(String email, String senha) throws RNException;
}
