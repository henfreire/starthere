package serviceImpl;

import java.util.List;

import DAO.EventoDAO;
import DAOImpl.EventoDAOImpl;
import model.Empresa;
import model.Evento;
import service.EventoService;
import util.FileHandler;
import util.RNException;

public class EventoServiceImpl implements EventoService<Evento, Empresa, Long> {	
	private EventoDAO evtDAO;
	
	public EventoServiceImpl() {
		evtDAO = new EventoDAOImpl ();
	}	
	
	@Override
	public void add(Evento element) throws RNException {
		// TODO Auto-generated method stub		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evento> getEventosByEmpresa(Empresa empresa) throws RNException {
		// TODO Auto-generated method stub
		return null;
	}

}
