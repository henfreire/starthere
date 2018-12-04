package DAOImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DAO.EmpresaDAO;
import DAO.UsuarioDAO;
import model.Empresa;
import model.Usuario;

import util.FileHandlerImpl;
import util.FileHandler;

public class EmpresaDAOImpl implements EmpresaDAO<Empresa, Long> {
	private final String FILE_NAME = "empresa.dat"; 
	private FileHandler<Empresa> fileManager;
	private UsuarioDAO<Usuario, Long> userDAO;
	
	public EmpresaDAOImpl() {
		this.userDAO = new UsuarioDAOImpl ();
		this.fileManager = new FileHandlerImpl <Empresa> (FILE_NAME);
	}

	@Override
	public Empresa getByEmail(String email) {
		Empresa empresa = null;
		Usuario usuario = this.userDAO.getByEmail(email); 
		
		if(usuario != null) {
			empresa = new Empresa (usuario);
			empresa.setUserData(usuario);
		}

		return empresa;
	}

	@Override
	public List<Empresa> getAll() {
		List<Empresa> empresas = new ArrayList<Empresa> (); 
		List<String> fileContents = fileManager.getFileContents();

		Empresa empresa = null;
		
		for(String str : fileContents) {
			empresa = new Empresa ();
			empresa.setDAT(str);
			empresas.add(empresa);
		}
		
		return empresas;
	}

	@Override
	public Empresa get(Long id) {
		List<Empresa> empresas = getAll();
		
		return  empresas.stream()
				.filter(empresa -> empresa.getId().equals(id))
				.findAny()
				.orElse(null);
	}

	@Override
	public void add(Empresa empresa) {
		this.userDAO.add(empresa);  // Gets next id by reference.
		fileManager.saveToFile(empresa);
	}

	@Override
	public void update(Empresa empresa) {
		List<Empresa> empresas = this.getAll();
		Empresa emp = empresas.stream()
							  .filter(element -> element.getId().equals(empresa.getId()))
							  .findAny()
							  .orElse(null);
		
		if(emp != null) {
			int index = empresas.indexOf(emp);
			
			if(index != -1) {
				empresas.set(index, emp);
			}
			
			fileManager.saveToFile(empresas);
			this.userDAO.update(empresa); 
		}
	}

	@Override
	public Empresa delete(Empresa empresa) {
		List<Empresa> empresas = this.getAll();
		Iterator<Empresa> itEmp = empresas.iterator();
		Empresa emp = null;
		
		while(itEmp.hasNext()) {
			emp = itEmp.next();
			
			if(emp.getId().equals(empresa.getId())) {
				itEmp.remove();
				fileManager.saveToFile(empresas);
				this.userDAO.delete(empresa); 
				break;
			}
		}
		
		return emp;
	}	
}
