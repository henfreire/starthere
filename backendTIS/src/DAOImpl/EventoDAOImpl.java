package DAOImpl;

import java.util.List;

import DAO.EventoDAO;
import model.Empresa;
import model.Evento;
import util.FileHandler;
import util.FileHandlerImpl;

public class EventoDAOImpl implements EventoDAO<Evento, Empresa, Long> {
	private static final String FILE_NAME = "eventos.dat"; 
	protected FileHandler<Evento> fileManager;

	public EventoDAOImpl() {
		this.fileManager = new FileHandlerImpl<Evento>(FILE_NAME);
	}

	@Override
	public List<Evento> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evento get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Evento ele) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Evento ele) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Evento delete(Evento ele) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evento> getEventos(Empresa empresa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evento> getEventosByEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evento getEvento(Long chave) {
		// TODO Auto-generated method stub
		return null;
	}	


}
