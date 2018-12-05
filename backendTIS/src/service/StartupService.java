package service;

import util.RNException;

public interface StartupService<Stp, Key> extends UsuarioService<Stp, Key> {
	public void salvarRanking (Stp stp) throws RNException;
}
