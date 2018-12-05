package serviceImpl;

import DAO.UsuarioDAO;
import DAOImpl.UsuarioDAOImpl;
import model.IUsuario;
import service.LoginService;
import util.RNException;

public class LoginServiceImpl implements LoginService<IUsuario> {
	private UsuarioDAO<IUsuario, Long> userDAO;
	
	public LoginServiceImpl () {
		this.userDAO = new UsuarioDAOImpl ();
	}
	
	@Override
	public IUsuario login(String email, String senha) throws RNException {
		IUsuario user;
		
		if(email == null)
			throw new RNException("O email não pode ser nulo !");
		
		if(senha == null)
			throw new RNException("A senha não pode ser nula !");
				
		user = this.userDAO.getByEmail(email);
		
		if((user == null) || (user != null && !isValidPassword(user, senha)))
			throw new RNException("Credenciais inválidas !");
			
		return user;
	}

	public boolean isValidPassword(IUsuario user, String senha) {
		return user.getSenha().equals(senha);
	}
}
