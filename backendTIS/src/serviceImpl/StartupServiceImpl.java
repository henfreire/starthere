package serviceImpl;

import java.util.List;

import DAO.StartupDAO;
import DAOImpl.DAOException;
import DAOImpl.StartupDAOImpl;
import model.Startup;
import service.StartupService;
import util.RNException;

public class StartupServiceImpl implements StartupService<Startup, Long> {
	private StartupDAO<Startup, Long> stpDAO;
	
	public StartupServiceImpl() {
		stpDAO = new StartupDAOImpl ();
	}

	@Override
	public Startup getUsuarioByEmail(String email) throws RNException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void add(Startup stp) throws RNException {
		try {
			this.stpDAO.add(stp);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException(e.getMessage());
		}
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
}
