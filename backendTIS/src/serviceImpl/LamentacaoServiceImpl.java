package serviceImpl;

import DAO.LamentacaoDAO;
import DAOImpl.DAOException;
import DAOImpl.LamentacaoDAOImpl;
import model.Lamentacao;
import service.LamentacaoService;

public class LamentacaoServiceImpl implements LamentacaoService<Lamentacao> {
	private LamentacaoDAO<Lamentacao, Integer> lamDAO;
	
	LamentacaoServiceImpl() {
		this.lamDAO = new LamentacaoDAOImpl ();
	}
	
	@Override
	public void add(Lamentacao lamentacao) {
		try {
			this.lamDAO.add(lamentacao);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
}
