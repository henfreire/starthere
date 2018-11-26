package DAOImpl;

import java.util.List;

import DAO.StartupDAO;
import DAO.UsuarioDAO;

import model.Startup;

import util.FileHandler;
import util.FileHandlerImpl;

public class StartupDAOImpl implements StartupDAO<Startup> {
	private static final String FILE_NAME = "startup.dat"; 
	private FileHandler<Startup> fileManager;
	private UsuarioDAO<Startup> userDAO;
	
	public StartupDAOImpl() {
		this.fileManager = new FileHandlerImpl<Startup>(FILE_NAME);		
		this.userDAO = new UsuarioDAOImpl();
	}

	@Override
	public Startup getByEmail(String nome) {
		Startup stp = this.userDAO.getByEmail(nome);
		
		//
		//
		//
		
		return stp;
	}

	@Override
	public List<Startup> getAll() {
		List<Startup> startups = this.userDAO.getAll();
		
		// 
		// 
		// 
		
		return startups;
	}

	@Override
	public Startup get(Long id) {
		Startup stp = this.userDAO.get(id);
		return stp;
	}

	@Override
	public void add(Startup ele) {
		this.userDAO.add(ele);
	}

	@Override
	public void update(Startup ele) {
		this.userDAO.update(ele);
	}

	@Override
	public Startup delete(Startup ele) {
		Startup stp = this.userDAO.delete(ele);
		
		if(stp != null) {
			this.userDAO.delete(ele);
		}
		
		return ele;
	}
}
