package DAOImpl;

import java.util.ArrayList;
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
		this.userDAO = new UsuarioDAOImpl (FILE_NAME);
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
		List<Usuario> usuarios = this.userDAO.getAll();
		
		usuarios.stream()
				.forEach(usr -> empresas.add(new Empresa(usr)) );
		
		return empresas;
	}

	@Override
	public Empresa get(Long id) {
		return new Empresa (this.userDAO.get(id));
	}

	@Override
	public void add(Empresa ele) {
		
	}

	@Override
	public void update(Empresa ele) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Empresa delete(Empresa ele) {
		// TODO Auto-generated method stub
		return null;
	}	
}
