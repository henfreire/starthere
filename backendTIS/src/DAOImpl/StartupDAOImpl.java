package DAOImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DAO.StartupDAO;
import DAO.UsuarioDAO;

import model.Startup;
import model.Usuario;

import util.FileHandler;
import util.FileHandlerImpl;

public class StartupDAOImpl implements StartupDAO<Startup, Long> {
	private final String FILE_NAME = "startup.dat"; 
	private FileHandler<Startup> fileManager;
	private UsuarioDAO<Usuario, Long> userDAO;
	
	public StartupDAOImpl() {
		this.userDAO = new UsuarioDAOImpl ();
		this.fileManager = new FileHandlerImpl<Startup>(FILE_NAME);
	}
	
	@Override
	public Startup getByEmail(String email) {
		Startup startup = null;
		Usuario usuario = this.userDAO.getByEmail(email); 
		
		if(usuario != null) {
			startup = new Startup (usuario);
			startup.setUserData(usuario);
		}

		return startup;
	}

	@Override
	public List<Startup> getAll() {
		List<Startup> startups = new ArrayList<Startup> ();
		List<String> fileContents = fileManager.getFileContents();

		Startup startup = null;
		
		for(String str : fileContents) {
			startup = new Startup ();
			startup.setDAT(str);
			startups.add(startup);
		}
		
		return startups;
	}

	@Override
	public Startup get(Long id) {
		List<Startup> startups = getAll();
		
		return  startups.stream()
				.filter(startup -> startup.getId().equals(id))
				.findAny()
				.orElse(null);
	}

	@Override
	public void add(Startup startup) {
		this.userDAO.add(startup);  // Gets next id by reference.
		fileManager.saveToFile(startup);
	}

	@Override
	public void update(Startup startup) {
		List<Startup> startups = this.getAll();
		Startup stp = startups.stream()
							  .filter(element -> element.getId().equals(startup.getId()))
							  .findAny()
							  .orElse(null);
		
		if(stp != null) {
			int index = startups.indexOf(stp);
			
			if(index != -1) {
				startups.set(index, stp);
			}
			
			fileManager.saveToFile(startups);
			this.userDAO.update(startup); 
		} 
	}

	@Override
	public Startup delete(Startup startup) {
		List<Startup> startups = this.getAll();
		Iterator<Startup> itStp = startups.iterator();
		Startup emp = null;
		
		while(itStp.hasNext()) {
			emp = itStp.next();
			
			if(emp.getId().equals(startup.getId())) {
				itStp.remove();
				fileManager.saveToFile(startups);
				this.userDAO.delete(startup); 
				break;
			}
		}
		
		return emp;
	}	
}
