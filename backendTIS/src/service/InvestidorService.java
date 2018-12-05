package service;

import java.util.List;

import util.RNException;

public interface InvestidorService <Inv, Stp, Key, Quest> extends UsuarioService<Inv, Key> {
	public List<Stp> buscarStartups() throws RNException;	
	public void avaliarStartup(Stp stp, Quest rank) throws RNException;
}
