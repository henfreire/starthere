package serviceImpl;

import java.util.List;

import DAO.QuestionarioDAO;
import DAO.StartupDAO;
import DAOImpl.DAOException;
import DAOImpl.QuestionarioDAOImpl;
import DAOImpl.StartupDAOImpl;
import model.Startup;
import service.StartupService;
import util.RNException;

public class StartupServiceImpl implements StartupService<Startup, Long> {
	private StartupDAO<Startup, Long> stpDAO;
	private QuestionarioDAO<Startup> questDAO;
	
	public StartupServiceImpl() {
		stpDAO = new StartupDAOImpl ();
		questDAO = new QuestionarioDAOImpl ();
	}

	@Override
	public Startup getUsuarioByEmail(String email) throws RNException {
		return this.stpDAO.getByEmail(email);
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
	public void update(Startup stp) throws RNException {
		this.stpDAO.update(stp);
	}

	@Override
	public Startup delete(Long id) throws RNException {
		return this.stpDAO.delete(this.stpDAO.get(id));
	}

	@Override
	public List<Startup> getAll() throws RNException {
		return this.stpDAO.getAll();
	}

	@Override
	public Startup getUsuario(Long id) throws RNException {
		return this.stpDAO.get(id);
	}

	@Override
	public void salvarRanking(Startup stp) throws RNException {
		this.questDAO.salvarRanking(stp);
	}
}
