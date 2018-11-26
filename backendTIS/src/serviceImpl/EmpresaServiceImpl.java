package serviceImpl;

import java.util.List;

import DAOImpl.EmpresaDAOImpl;
import model.Empresa;
import model.Evento;
import model.Startup;
import service.EmpresaService;
import util.RNException;

public class EmpresaServiceImpl implements EmpresaService<Empresa, Startup, Evento> {
	private UsuarioService<Empresa> userService;
	
	public EmpresaServiceImpl() {
		this.usrDAO = new EmpresaDAOImpl();
	}

	@Override
	public void criarEvento(Evento evento) throws RNException {
		
	}

	@Override
	public List<Startup> buscarStartups() throws RNException {
		return null;
	}

	@Override
	public Empresa getUsuario(Long id) throws RNException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empresa getUsuarioByEmail(String email) throws RNException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empresa autenticar(String email, String senha) throws RNException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Empresa element) throws RNException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Empresa element) throws RNException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Empresa delete(Long id) throws RNException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empresa> getAll() throws RNException {
		// TODO Auto-generated method stub
		return null;
	}

}
