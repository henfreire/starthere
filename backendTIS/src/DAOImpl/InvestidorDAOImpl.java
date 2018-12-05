package DAOImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DAO.InvestidorDAO;
import DAO.UsuarioDAO;

import model.IUsuario;
import model.Investidor;

import util.FileHandler;
import util.FileHandlerImpl;

public class InvestidorDAOImpl implements InvestidorDAO<Investidor, Long> {
	private final String FILE_NAME = "investidor.dat"; 
	private FileHandler<Investidor> fileManager;
	private UsuarioDAO<IUsuario, Long> userDAO;
	
	public InvestidorDAOImpl() {
		this.userDAO = new UsuarioDAOImpl ();
		this.fileManager = new FileHandlerImpl<Investidor>(FILE_NAME);
	}
	
	@Override
	public Investidor getByEmail(String email) {
		Investidor investidor = null;
		IUsuario usuario = this.userDAO.getByEmail(email); 
		
		if(usuario != null) {
			investidor = new Investidor (usuario);
			investidor.setUserData(usuario);
		}

		return investidor;
	}

	@Override
	public List<Investidor> getAll() {
		List<Investidor> investidores = new ArrayList<Investidor> ();
		List<String> fileContents = fileManager.getFileContents();
		Investidor investidor;
		
		for(String str : fileContents) {
			investidor = new Investidor ();
			investidor.setDAT(str);
			investidores.add(investidor);
		}
		
		return investidores;
	}

	@Override
	public Investidor get(Long id) {
		List<Investidor> investidores = getAll();
		
		return  investidores.stream()
				.filter(investidor -> investidor.getId().equals(id))
				.findAny()
				.orElse(null);
	}

	@Override
	public void add(Investidor investidor) throws DAOException {		
		this.userDAO.add(investidor);  // Gets next id by reference.
		fileManager.saveToFile(investidor);
	}

	@Override
	public void update(Investidor investidor) {
		List<Investidor> investidores = this.getAll();
		Investidor stp = investidores.stream()
							  .filter(element -> element.getId().equals(investidor.getId()))
							  .findAny()
							  .orElse(null);
		
		if(stp != null) {
			int index = investidores.indexOf(stp);
			
			if(index != -1) {
				investidores.set(index, stp);
			}
			
			fileManager.saveToFile(investidores);
			this.userDAO.update(investidor); 
		}
	}

	@Override
	public Investidor delete(Investidor investidor) {
		List<Investidor> investidores = this.getAll();
		Iterator<Investidor> itInv = investidores.iterator();
		Investidor inv = null;
		
		while(itInv.hasNext()) {
			inv = itInv.next();
			
			if(inv.getId().equals(investidor.getId())) {
				itInv.remove();
				fileManager.saveToFile(investidores);
				this.userDAO.delete(investidor); 
				break;
			}
		}
		
		return investidor;
	}
}
