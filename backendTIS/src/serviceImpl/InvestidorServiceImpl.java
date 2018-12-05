package serviceImpl;

import java.util.List;

import DAO.InvestidorDAO;
import DAOImpl.DAOException;
import DAOImpl.InvestidorDAOImpl;

import model.Evento;
import model.Investidor;
import model.Ranking;
import model.Startup;

import service.InvestidorService;
import util.RNException;

public class InvestidorServiceImpl implements InvestidorService<Investidor, Startup, Evento, Long, Ranking<Integer> > {
	private InvestidorDAO<Investidor, Long> investidorDAO;
	
	public InvestidorServiceImpl() {
		this.investidorDAO = new InvestidorDAOImpl ();
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
		return null;
	}

	@Override
	public void avaliarStartup(Startup stp, Ranking<Integer> rank) throws RNException {
		
	}	
}
