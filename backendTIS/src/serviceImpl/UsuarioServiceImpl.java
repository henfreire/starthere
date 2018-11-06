package serviceImpl;

import java.util.List;

import DAO.UsuarioDAO;
import model.Usuario;
import service.UsuarioService;
import util.RNException;

public abstract class UsuarioServiceImpl<E extends Usuario> implements UsuarioService<E, Long> {
	protected UsuarioDAO<E, Long> usrDAO;
	
	@Override
	public void update(E user) throws RNException {
		this.usrDAO.update(user);
	}

	@Override
	public E delete(Long id) throws RNException {
		if(id == null || id.intValue() == 0)
			throw new RNException("O ID é inválido !");
		
		E user = this.usrDAO.get(id);
		
		if(user == null)
			throw new RNException("O ID informado não corresponde a nenhum usuário!");
		
		return this.usrDAO.delete(user);
	}

	@Override
	public List<E> getAll() throws RNException {
		return this.usrDAO.getAll();
	}

	@Override
	public void add(E user) throws RNException {
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
	public E getUsuario(Long id) throws RNException {
		return this.usrDAO.get(id);
	}
	
	@Override
	public E getUsuarioByEmail(String email) throws RNException {
		return this.usrDAO.getByEmail(email);
	}
	
	@Override
	public E autenticar(String email, String senha) throws RNException {
		E user;
		
		if(email == null)
			throw new RNException("O email não pode ser nulo !");
		
		if(senha == null)
			throw new RNException("A senha não pode ser nula !");
				
		user = this.usrDAO.getByEmail(email);
		
		if(user != null && !isValidPassword((Usuario) user, senha))
			throw new RNException("Credenciais inválidas !");
			
		return user;
	}
	
	private boolean isRegisteredEmail(String email) {
		E user = this.usrDAO.getByEmail(email);
		return user != null;
	}
	
	public boolean isValidPassword(Usuario user, String senha) {
		return user.getSenha().equals(senha);
	}
}
