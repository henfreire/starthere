package service;

import util.RNException;

public interface LoginService<Usr> {
	public Usr login(String email, String senha) throws RNException;
}
