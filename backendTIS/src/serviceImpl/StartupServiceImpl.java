package serviceImpl;

import DAOImpl.StartupDAOImpl;
import model.Startup;
import service.StartupService;

public class StartupServiceImpl extends UsuarioServiceImpl<Startup> implements StartupService<Startup, Long> {
	public StartupServiceImpl() {
		this.usrDAO = new StartupDAOImpl();
	}
}
