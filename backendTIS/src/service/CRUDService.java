package service;

import java.util.List;

import util.RNException;

public interface CRUDService<Ele, Key> {
	public void add(Ele element) throws RNException;
	public void update(Ele element) throws RNException;
	public Ele delete(Key id) throws RNException;
	public List<Ele> getAll() throws RNException;
}
