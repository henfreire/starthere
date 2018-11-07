package service;

import java.util.List;

import util.RNException;

public interface EventoService<Evt, Emp, Key> extends CRUDService<Evt, Key> {
	public List<Evt> getEventosByEmpresa(Emp empresa) throws RNException;
}
