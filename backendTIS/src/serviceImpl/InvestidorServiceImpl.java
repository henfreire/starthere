package serviceImpl;

import java.util.List;

import DAO.InvestidorDAO;

import DAOImpl.DAOException;
import DAOImpl.InvestidorDAOImpl;

import model.IQuestionario;
import model.Investidor;
import model.Startup;

import service.InvestidorService;
import service.StartupService;
import util.RNException;

public class InvestidorServiceImpl implements InvestidorService<Investidor, Startup, Long, IQuestionario<String>> {
	private InvestidorDAO<Investidor, Long> investidorDAO;
	
	private StartupService <Startup, Long> stpService;
	
	public InvestidorServiceImpl() {
		this.investidorDAO = new InvestidorDAOImpl  ();
		this.stpService    = new StartupServiceImpl ();
	}

	@Override
	public Investidor getUsuario(Long id) throws RNException {
		return this.investidorDAO.get(id);
	}

	@Override
	public Investidor getUsuarioByEmail(String email) throws RNException {
		return this.investidorDAO.getByEmail(email);
	}

	@Override
	public void add(Investidor inv) throws RNException {
		try {
			this.investidorDAO.add(inv);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new RNException(e.getMessage());
		}
	}

	@Override
	public void update(Investidor inv) throws RNException {
		this.investidorDAO.update(inv);
	}

	@Override
	public Investidor delete(Long id) throws RNException {
		return this.investidorDAO.delete(this.investidorDAO.get(id));
	}

	@Override
	public List<Investidor> getAll() throws RNException {
		return this.investidorDAO.getAll();
	}

	@Override
	public List<Startup> buscarStartups() throws RNException {
		return this.stpService.getAll();
	}

	@Override
	public void avaliarStartup(Startup stp, IQuestionario<String> quest) throws RNException {
		// Not Implemented Yet
	}	
}
