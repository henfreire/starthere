package service;

import java.util.List;

import DAO.EmpresaDAO;
import DAOImpl.EmpresaDAOImpl;
import model.Empresa;
import model.Usuario;

public class EmpresaService implements UsuarioService {
	private EmpresaDAO<Empresa, Long> empDAO;
	
	public EmpresaService() {}
	
	@Override
	public void add(String nome, String email, String senha) throws Exception {
		EmpresaDAO<Empresa, Long> empDAO = new EmpresaDAOImpl();
		
		if(nome == null) 
			throw new Exception("O nome não pode ser nulo");
		
		if(email ==  null)
			throw new Exception("O email não pode ser nulo");
		
		Long id = empDAO.getNextId();
		
		Empresa empresa = new Empresa(id, nome, senha, email);
		empDAO.addEmpresa(empresa);
	}

	@Override
	public void delete(long id) {
//		this.empDAO = new EmpresaDAOImpl();
//		Empresa empresa = empDAO.deleteEmpresa(empresa);
//		return empresa;
	}

	@Override
	public Usuario buscar(String email) {
//		if(email ==  null)
//			throw new Exception("O email não pode ser nulo !");
//		
		this.empDAO = new EmpresaDAOImpl();
		
		Empresa empresa = empDAO.getEmpresa(Long.parseLong(email));
		
		return empresa;
	}

	@Override
	public Usuario buscar(long id) {
		// not implemented yet.
		return null;
	}

	public List<Empresa> getAll() {
		this.empDAO = new EmpresaDAOImpl();
		return this.empDAO.getEmpresas();
	}

	public Empresa getEmpresaById(long idEmpresa) {
		this.empDAO = new EmpresaDAOImpl();
		Empresa empresa = empDAO.getEmpresa(idEmpresa);		
		return empresa;
	}

}
