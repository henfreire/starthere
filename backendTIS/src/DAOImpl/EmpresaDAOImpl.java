package DAOImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DAO.EmpresaDAO;
import DAO.UsuarioDAO;

import model.Empresa;
import model.Usuario;

import util.FileHandler;
import util.FileHandlerImpl;

public class EmpresaDAOImpl implements EmpresaDAO<Empresa> {
	private final String FILE_NAME = "empresa.dat"; 
	private UsuarioDAO<Usuario> userDAO; 
	private FileHandler<Empresa> fileManager;
	
	public EmpresaDAOImpl() {
		userDAO = new UsuarioDAOImpl ();
		fileManager = new FileHandlerImpl<Empresa> (FILE_NAME); 
	}

	@Override
	public Empresa getByEmail(String nome) {
		Empresa emp = null;
		Usuario user = userDAO.getByEmail(nome);
		
		if(user != null) {
			emp = new Empresa();
			emp.setUserData(user);
		}
		
		return emp;
	}

	@Override
	public List<Empresa> getAll() {
		List<Empresa> empresas = new ArrayList<Empresa> ();
		List<Usuario> usuarios = this.userDAO.getAll();
		
		List<String> fileContents;
		
		Iterator<String> itStr;
		
		String  str;
		Empresa emp;

		fileContents = fileManager.getFileContents();

		itStr = fileContents.iterator();

		while(itStr.hasNext()) {
			str = itStr.next();
			
			emp = new Empresa ();
			emp.setDAT(str);
			
			Long id = emp.getId();
			
			Usuario aux = usuarios .stream()
								   .filter( user -> user.getId().equals(id))
								   .findAny()
								   .orElse(null);
			
			emp.setUserData(aux);
			
			empresas.add(emp);
		}
		
		return empresas;
	}

	@Override
	public Empresa get(Long id) {
		List<Empresa> empresas = this.getAll();
		
		Empresa empresa = null;

		empresa = empresas.stream()
				.filter(emp -> id.equals(emp.getId()))
				.findAny()
				.orElse(null);
		
		return empresa;
	}

	@Override
	public void add(Empresa ele) {
		this.userDAO.add(ele);
		this.fileManager.saveToFile(ele);
	}

	@Override
	public void update(Empresa ele) {
		List<Empresa> empresas = this.getAll();
		Empresa empresa = empresas.stream()
								  .filter(emp -> ele.getId().equals(emp.getId()))
								  .findAny()
								  .orElse(null);
		
		if(empresa != null) {
			empresa.setUserData(ele);
			this.userDAO.update(empresa);
			
			empresa.setRazaoSocial(ele.getRazaoSocial());
			this.fileManager.saveToFile(empresas);
		}
	}

	@Override
	public Empresa delete(Empresa ele) {
		List<Empresa> empresas = this.getAll();
		Empresa empresa = null;
		
		empresa = empresas.stream()
				.filter(emp -> emp.getId().equals(ele.getId()))
				.findAny()
				.orElse(null);
		
		if(empresas.remove(empresa)) {
			this.userDAO.delete(empresa);
			this.fileManager.saveToFile(empresas);
		}
		
		return empresa;
	}
}
