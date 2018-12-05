package serviceImpl;

import java.util.List;

import DAO.UsuarioDAO;
import DAOImpl.UsuarioDAOImpl;
import model.Usuario;
import service.LoginService;
import service.UsuarioService;
import util.RNException;

public class UsuarioServiceImpl implements UsuarioService<Usuario, Long>, LoginService<Usuario> {
	protected UsuarioDAO<Usuario, Long> usrDAO;
	
	public UsuarioServiceImpl () {
		this.usrDAO = new UsuarioDAOImpl();
	}
	
	@Override
	public void update(Usuario user) throws RNException {
		this.usrDAO.update(user);
	}

	@Override
	public Usuario delete(Long id) throws RNException {
		if(id == null || id.intValue() == 0)
			throw new RNException("O ID é inválido !");
		
		Usuario user = this.usrDAO.get(id);
		
		if(user == null)
			throw new RNException("O ID informado não corresponde a nenhum usuário!");
		
		return this.usrDAO.delete(user);
	}

	@Override
	public List<Usuario> getAll() throws RNException {
		return this.usrDAO.getAll();
	}

	@Override
	public void add(Usuario user) throws RNException {
		if(user.getNome() == null) 
			throw new RNException("O nome não pode ser nulo !");
		
		if(user.getEmail() == null)
			throw new RNException("O email não pode ser nulo !");
		
		if(user.getSenha() == null)
			throw new RNException("A senha não pode ser nula !");
		
		if(isRegisteredEmail(user.getEmail()))
			throw new RNException("Já existe um usuário com este email !");
				
		this.usrDAO.add(user);
	}
	
	@Override
	public Usuario getUsuario(Long id) throws RNException {
		return this.usrDAO.get(id);
	}
	
	@Override
	public Usuario getUsuarioByEmail(String email) throws RNException {
		return this.usrDAO.getByEmail(email);
	}
	
	@Override
	public Usuario login(String email, String senha) throws RNException {
		Usuario user;
		
		if(email == null)
			throw new RNException("O email não pode ser nulo !");
		
		if(senha == null)
			throw new RNException("A senha não pode ser nula !");
				
		user = this.usrDAO.getByEmail(email);
		
		if(user != null && !isValidPassword(user, senha))
			throw new RNException("Credenciais inválidas !");
			
		return user;
	}
	
	private boolean isRegisteredEmail(String email) {
		return this.usrDAO.getByEmail(email) != null;
	}
	
	public boolean isValidPassword(Usuario user, String senha) {
		return user.getSenha().equals(senha);
	}
}
