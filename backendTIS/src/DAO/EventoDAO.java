package DAO;

import java.util.List;

public interface EventoDAO<Evt, Key, Emp> extends CRUD<Evt, Key> {
	
	public List<Evt> getEventos(Emp empresa);
	public List<Evt> getEventosByEmpresa(Emp empresa);
	
	public Evt getEvento(Key chave);
}
