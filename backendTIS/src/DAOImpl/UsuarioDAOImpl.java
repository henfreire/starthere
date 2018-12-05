package DAOImpl;

import java.util.ArrayList;
import java.util.List;

import DAO.UsuarioDAO;

import model.IUsuario;
import model.Usuario;

import util.FileHandler;
import util.FileHandlerImpl;

public class UsuarioDAOImpl implements UsuarioDAO<IUsuario, Long> {
	private final String FILE_NAME = "usuarios.dat";
	private FileHandler<IUsuario> userFileManager;
	
	public UsuarioDAOImpl() {
		this.userFileManager = new FileHandlerImpl<IUsuario> (FILE_NAME);
	}
	
	public List<IUsuario> getAll() {
		List<IUsuario> usuarios = new ArrayList <IUsuario> ();
		List<String> fileContents = userFileManager.getFileContents();

		IUsuario usuario = null;
		
		for(String str : fileContents) {
			usuario = new Usuario ();
			usuario.setDAT(str);
			usuarios.add(usuario);
		}
		
		return usuarios;
	}

	@Override
	public IUsuario get(Long id) {
		List<IUsuario> empresas = getAll();
		
		return  empresas.stream()
				.filter(empresa -> empresa.getId().equals(id))
				.findAny()
				.orElse(null);
	}

	@Override
	public void add(IUsuario usuario) throws DAOException {
		if(this.getByEmail(usuario.getEmail()) != null)
			throw new DAOException ("Este email já está cadastrado !");

		usuario.setId(getNextId());
		userFileManager.saveToFile(usuario);
	}

	@Override
	public void update(IUsuario usuario) {
		List<IUsuario> usuarios = getAll();

		int index = usuarios.indexOf(usuario);
		
		if(index != -1) {
			usuarios.set(index, usuario);
		}
		
		userFileManager.saveToFile(usuarios);
	}

	@Override
	public IUsuario delete(IUsuario usuario) {
		List<IUsuario> usuarios = getAll();
		IUsuario aux = null;
		
		int index = usuarios.indexOf(usuario);
		
		if(index != -1) {
			aux = usuarios.remove(index);
		}
		
		userFileManager.saveToFile(usuarios);

		return aux;
	}

	@Override
	public IUsuario getByEmail(String email) {
		List<String> fileContents = userFileManager.getFileContents();
		IUsuario user = null;
		
		
		for(String str : fileContents) {
			user = new Usuario();
			user.setDAT(str);
			
			if(user.getEmail().equals(email))
				return user;
		}
		
		return null;
	}
	
	private Long getNextId() {
		List<IUsuario> usuarios = getAll();
		return Long.parseLong((usuarios.size() + 1) + "");
	}
}
