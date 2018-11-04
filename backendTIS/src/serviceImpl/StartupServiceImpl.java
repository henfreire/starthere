package serviceImpl;

import DAOImpl.StartupDAOImpl;
import model.Startup;

public class StartupServiceImpl extends UsuarioServiceImpl<Startup> {
	public StartupServiceImpl() {
		super( new StartupDAOImpl() );
	}

	@Override
	public Startup buildNewUser(String nome, String email, String senha) {
		Startup startup = new Startup(nome, email);
		startup.setSenha(senha);
		return startup;
	}
}
