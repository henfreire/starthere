package service;

import util.RNException;

public interface UsuarioService <Usr> extends CRUDService <Usr, Long> {
	public Usr getUsuario(Long id) throws RNException;
	public Usr getUsuarioByEmail(String email) throws RNException;
	public Usr autenticar(String email, String senha) throws RNException;
}
