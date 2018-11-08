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
	public void add(Evento evento) throws RNException {
		if(evento.getNome() == null) 
			throw new RNException("O evento precisa ter nome !");

		if(evento.getDescricao() == null) 
			throw new RNException("O evento precisa ter descrição !");

		if(evento.getDataEvento() == null) 
			throw new RNException("O evento precisa ter data !");
		
		this.evtDAO.add(evento);
	}

	@Override
	public void update(Evento element) throws RNException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Evento delete(Long id) throws RNException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evento> getAll() throws RNException {
		return this.evtDAO.getAll();
	}

	@Override
	public List<Evento> getEventosByEmpresa(Empresa empresa) throws RNException {
		// TODO Auto-generated method stub
		return null;
	}

}
