package serviceImpl;

import java.util.List;

import DAOImpl.InvestidorDAOImpl;
import model.Evento;
import model.Investidor;
import model.Ranking;
import model.Startup;
import service.InvestidorService;
import util.RNException;

public class InvestidorServiceImpl extends UsuarioServiceImpl<Investidor> implements InvestidorService<Investidor, Startup, Evento, Long, Ranking<Integer> > {
	public InvestidorServiceImpl() {
		this.usrDAO = new InvestidorDAOImpl();
	}

	@Override
	public List<Startup> buscarStartups() throws RNException {
		return null;
	}

	@Override
	public void avaliarStartup(Startup stp, Ranking<Integer> rank) throws RNException {
		
	}
	
}
