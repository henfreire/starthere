package DAOImpl;

import DAO.StartupDAO;
import model.Startup;
import util.FileHandlerImpl;

public class StartupDAOImpl extends UsuarioDAOImpl<Startup> implements StartupDAO<Startup, Long> {
	private static final String FILE_NAME = "startup.dat"; 
	
	public StartupDAOImpl() {
		this.fileManager = new FileHandlerImpl<Startup>(FILE_NAME);
	}
}
