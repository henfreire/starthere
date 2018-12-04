package serviceImpl;

import java.util.List;

import DAO.EventoDAO;
import DAOImpl.EventoDAOImpl;
import model.Empresa;
import model.Evento;
import service.EventoService;
import util.RNException;

public class EventoServiceImpl implements EventoService<Evento, Empresa, Long> {	
	private EventoDAO<Evento, Empresa, Long> evtDAO;
	
	public EventoServiceImpl() {
		evtDAO = new EventoDAOImpl ();
	}	
	
	@Override
	public void add(Empresa empresa, Evento evento) throws RNException {
		if(empresa.getId() == null)
			throw new RNException("A empresa precisa ter um ID !");
		
		if(evento.getNome() == null) 
			throw new RNException("O evento precisa ter nome !");

		if(evento.getDescricao() == null) 
			throw new RNException("O evento precisa ter descrição !");

		if(evento.getDataEvento() == null) 
			throw new RNException("O evento precisa ter data !");
		
		this.evtDAO.add(evento);
	}

	@Override
	public void update(Empresa empresa, Evento evento) throws RNException {
		if(empresa.getId() == null)
			throw new RNException("A empresa precisa ter um ID !");
		
		if(evento.getNome() == null) 
			throw new RNException("O evento precisa ter nome !");

		if(evento.getDescricao() == null) 
			throw new RNException("O evento precisa ter descrição !");

		if(evento.getDataEvento() == null) 
			throw new RNException("O evento precisa ter data !");
		
		this.evtDAO.update(evento);
	}

	@Override
	public Evento delete(Long id) throws RNException {
		Evento evt = new Evento ();
		evt.setId(id);
		return this.evtDAO.delete(evt);
	}

	@Override
	public List<Evento> getAll() throws RNException {
		return this.evtDAO.getAll();
	}

	@Override
	public List<Evento> getEventosByEmpresa(Empresa empresa) throws RNException {
		return null;
	}
}
