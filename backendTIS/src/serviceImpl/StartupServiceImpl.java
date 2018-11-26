package serviceImpl;

import java.util.List;

import DAOImpl.StartupDAOImpl;
import model.Startup;
import service.UsuarioService;
import util.RNException;

public class StartupServiceImpl implements UsuarioService<Startup> {
	private UsuarioService<Startup> userService;
	
	public StartupServiceImpl() {
//		this.userService; 
		
		// = new StartupDAOImpl();
	}

	@Override
	public void add(Startup element) throws RNException {
		
	}

	@Override
	public void update(Startup element) throws RNException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Startup delete(Long id) throws RNException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Startup> getAll() throws RNException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Startup getUsuario(Long id) throws RNException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Startup getUsuarioByEmail(String email) throws RNException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Startup autenticar(String email, String senha) throws RNException {
		// TODO Auto-generated method stub
		return null;
	}
}
