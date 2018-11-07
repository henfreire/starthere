package DAOImpl;

import DAO.InvestidorDAO;
import model.Investidor;
import util.FileHandlerImpl;

public class InvestidorDAOImpl extends UsuarioDAOImpl<Investidor> implements InvestidorDAO<Investidor, Long> {
	private static final String FILE_NAME = "investidor.dat"; 
	
	public InvestidorDAOImpl() {
		this.fileManager = new FileHandlerImpl<Investidor>(FILE_NAME);
	}	
}
