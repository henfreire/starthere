package DAOImpl;

import DAO.QuestionarioDAO;
import model.Startup;
import util.FileHandler;
import util.FileHandlerImpl;

public class QuestionarioDAOImpl implements QuestionarioDAO<Startup> {
	private static final String FILE_NAME = "eventos.dat"; 
	protected FileHandler<Startup> fileManager;

	public QuestionarioDAOImpl() {
		this.fileManager = new FileHandlerImpl <Startup> (FILE_NAME);
	}
	
	@Override
	public void salvarRanking(Startup startup) {
		
	}
	
}
