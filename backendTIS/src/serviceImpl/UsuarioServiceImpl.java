package serviceImpl;

import java.util.List;

import DAO.UsuarioDAO;
import model.Usuario;
import util.RNException;

public abstract class UsuarioServiceImpl<E> {
	UsuarioDAO<E, Long> usrDAO;
	
	public UsuarioServiceImpl(UsuarioDAO<E, Long> usrDAO) {
		this.usrDAO = usrDAO;
	}
	
	public void addUser(String nome, String email, String senha) throws RNException {
		if(nome == null) 
			throw new RNException("O nome não pode ser nulo !");
		
		if(email ==  null)
			throw new RNException("O email não pode ser nulo !");
		
		if(senha == null)
			throw new RNException("A senha não pode ser nula !");
		
		if(isRegisteredEmail(email))
			throw new RNException("Já existe um usuário com este email !");
		
		E user = buildNewUser(nome, email, senha);
		
		this.usrDAO.add(user);
	}

	public abstract E buildNewUser(String nome, String email, String senha);

	public E delete(Long id) throws RNException {
		return this.usrDAO.delete(this.usrDAO.get(id));
	}
	
	public List<E> getAllUsers() throws RNException {
		return this.usrDAO.getAll();
	}
	
	public E getUser(Long id) throws RNException {
		return this.usrDAO.get(id);
	}
	
	public E getUserByEmail(String nome) throws RNException {
		return this.usrDAO.getByEmail(nome);
	}
	
	public E auth(String email, String senha) throws RNException {
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
		return this.usrDAO.getByEmail(email) == null;
	}
	
	public boolean isValidPassword(Usuario user, String senha) {
		return user.getSenha().equals(senha);
	}
}
