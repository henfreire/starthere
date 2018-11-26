package DAOImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DAO.EventoDAO;
import model.Empresa;
import model.Evento;
import util.FileHandler;
import util.FileHandlerImpl;

public class EventoDAOImpl implements EventoDAO<Evento, Empresa> {
	private final String FILE_NAME = "eventos.dat"; 
	protected FileHandler<Evento> fileManager;

	public EventoDAOImpl() {
		this.fileManager = new FileHandlerImpl<Evento>(FILE_NAME);
	}

	@Override
	public List<Evento> getAll() {
		List<Evento> eventos = new ArrayList<Evento>();
		List<String> fileContents;
		
		String  str;
		
		Evento evento = null;
		fileContents = fileManager.getFileContents();
		
		Iterator<String> itStr = fileContents.iterator();
		
		while(itStr.hasNext()) {
			str = itStr.next();
			
			evento = new Evento ();
			evento.setDAT(str);
	
			eventos.add(evento);
		}
			
		return eventos;
	}

	@Override
	public Evento get(Long id) {
		List<Evento> eventos = this.getAll();
		return eventos.stream()
					  .filter(evt -> evt.getId().equals(id))
					  .findAny()
					  .orElse(null);
	}

	@Override
	public void add(Evento evento) {
		Long id = getNextId();
		evento.setId(id);
		fileManager.saveToFile(evento);
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
	public List<Evento> getEventosByEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		return null;
	}

	private Long getNextId() {
		List<Evento> eventos = getAll();
		Long id = eventos.get(eventos.size()).getId();
		return id + 1L;
	}
}
