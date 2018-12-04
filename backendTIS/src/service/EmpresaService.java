package service;

import java.util.List;

import util.RNException;

public interface EmpresaService<Emp, Stp, Evt, Key> extends UsuarioService<Emp, Key> {
	public void criarEvento(Emp empresa, Evt evento) throws RNException;
	public List<Stp> buscarStartups() throws RNException;
}
