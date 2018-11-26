package service;

import java.util.List;

import util.RNException;

public interface EmpresaService<Emp, Stp, Evt> extends UsuarioService<Emp> {
	public void criarEvento(Evt evento) throws RNException;
	public List<Stp> buscarStartups() throws RNException;
}
