package service;

import java.util.List;

import util.RNException;

public interface InvestidorService <Inv, Stp, Evt, Key, Rank> extends UsuarioService<Inv, Key> {
	public List<Stp> buscarStartups() throws RNException;	
	public void avaliarStartup(Stp stp, Rank rank) throws RNException;
}
