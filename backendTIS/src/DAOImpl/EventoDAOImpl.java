package DAOImpl;

import java.util.ArrayList;
import java.util.Iterator;
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
		List<Evento> empresas = new ArrayList<Evento>();
		List<String> fileContents;
		String  str, 
				vet[];
		Evento empresa = null;
		fileContents = fileManager.getFileContents();
		
		Iterator<String> itStr = fileContents.iterator();
		while(itStr.hasNext()) {
			str = itStr.next();
			vet = str.split("[|]");
			
			empresa = new Evento ();
			empresa.setId(Long.parseLong(vet[0]));
			empresa.setNome(vet[1]);
			empresa.setDescricao(vet[2]);
//			empresa.setDataEvento(vet[3]);
			
			empresas.add(empresa);
		}
			
		return empresas;
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

	private Long getNextId() {
		List<Evento> empresas = getAll();
		return Long.parseLong((empresas.size() + 1) + "");
	}

}
