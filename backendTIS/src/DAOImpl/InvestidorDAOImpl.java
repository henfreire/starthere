package DAOImpl;

import java.util.List;

import DAO.InvestidorDAO;
import model.Investidor;
import util.FileHandlerImpl;

public class InvestidorDAOImpl extends UsuarioDAOImpl<Investidor> implements InvestidorDAO<Investidor, Long> {
	private static final String FILE_NAME = "investidor.dat"; 
	
	public InvestidorDAOImpl() {
		this.fileManager = new FileHandlerImpl<Investidor>(FILE_NAME);
	}

	@Override
	public Investidor getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Investidor> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Investidor get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Investidor ele) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Investidor ele) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Investidor delete(Investidor ele) {
		// TODO Auto-generated method stub
		return null;
	}	
}
