package service;

import java.util.List;

import util.RNException;

public interface EventoService<Evt, Emp, Key> {
	public void add(Emp emp, Evt evento) throws RNException;
	public void update(Emp emp, Evt evento) throws RNException;
	public Evt delete(Key id) throws RNException;
	public List<Evt> getAll() throws RNException;
	public List<Evt> getEventosByEmpresa(Emp empresa) throws RNException;
}
