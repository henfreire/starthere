package DAOImpl;

import java.util.List;

import DAO.StartupDAO;
import model.Startup;
import util.FileHandlerImpl;

public class StartupDAOImpl extends UsuarioDAOImpl implements StartupDAO<Startup, Long> {
	private static final String FILE_NAME = "startup.dat"; 
	
	public StartupDAOImpl() {
		this.fileManager = new FileHandlerImpl<Startup>(FILE_NAME);
	}

	@Override
	public Startup getByEmail(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Startup> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Startup get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Startup ele) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Startup ele) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Startup delete(Startup ele) {
		// TODO Auto-generated method stub
		return null;
	}
}
