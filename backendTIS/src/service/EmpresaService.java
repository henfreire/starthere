package service;

import java.util.List;

import DAO.EmpresaDAO;
import DAOImpl.EmpresaDAOImpl;
import model.Empresa;
import model.Usuario;

public class EmpresaService implements UsuarioService {
	private EmpresaDAO<Empresa, Long> empDAO;
	
	public EmpresaService() {
		this.empDAO = new EmpresaDAOImpl();
	}
	
	@Override
	public void add(String nome, String email, String senha) throws Exception {
		EmpresaDAO<Empresa, Long> empDAO = new EmpresaDAOImpl();
		
		if(nome == null) 
			throw new Exception("O nome não pode ser nulo");
		
		if(email ==  null)
			throw new Exception("O email não pode ser nulo");
		
		Empresa empresa = new Empresa(nome, senha, email);
		empDAO.add(empresa);
	}

	@Override
	public Empresa delete(long id) throws Exception {
		Empresa empresa = empDAO.get(id);
		return empDAO.delete(empresa);
	}

	@Override
	public Usuario buscar(String email) throws Exception {
		if(email ==  null)
			throw new Exception("O email não pode ser nulo !");
		
		return empDAO.getByNome(email);
	}

	@Override
	public Usuario buscar(long id) {
		return empDAO.get(id);
	}

	public List<Empresa> getAll() {
		return empDAO.getAll();
	}

	public Empresa getEmpresaById(long idEmpresa) {
		return empDAO.get(idEmpresa);		
	}

}
