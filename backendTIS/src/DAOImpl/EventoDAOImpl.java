package DAOImpl;

import java.util.ArrayList;
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
		List<Evento> eventos = new ArrayList<Evento>();
		List<String> fileContents = fileManager.getFileContents();
		Evento evento = null;
		
		for(String DAT : fileContents) {
			evento = new Evento ();
			evento.setDAT(DAT);
			eventos.add(evento);
		}
		
		return eventos;
	}

	@Override
	public Evento get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Evento evento) {
		Long id = getNextId();
		evento.setId(id);
		fileManager.saveToFile(evento);
	}

	@Override
	public void update(Evento evento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Evento delete(Evento evento) {
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

	private Long getNextId() {
		List<Evento> empresas = getAll();
		return Long.parseLong((empresas.size() + 1) + "");
	}
}
