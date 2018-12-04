package DAOImpl;

import java.util.ArrayList;
import java.util.List;

import DAO.UsuarioDAO;
import model.Usuario;
import util.FileHandler;
import util.FileHandlerImpl;

public class UsuarioDAOImpl implements UsuarioDAO<Usuario, Long> {
	private final String FILE_NAME = "usuarios.dat";
	private FileHandler<Usuario> userFileManager;
	
	public UsuarioDAOImpl() {
		this.userFileManager = new FileHandlerImpl<Usuario> (FILE_NAME);
	}
	
	public List<Usuario> getAll() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		List<String> fileContents = userFileManager.getFileContents();

		Usuario usuario = null;
		
		for(String str : fileContents) {
			usuario = new Usuario ();
			usuario.setDAT(str);
			usuarios.add(usuario);
		}
		
		return usuarios;
	}

	@Override
	public Usuario get(Long id) {
		List<Usuario> empresas = getAll();
		
		return  empresas.stream()
				.filter(empresa -> empresa.getId().equals(id))
				.findAny()
				.orElse(null);
	}

	@Override
	public void add(Usuario usuario) {
		usuario.setId(getNextId());
		userFileManager.saveToFile(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		List<Usuario> usuarios = getAll();

		int index = usuarios.indexOf(usuario);
		
		if(index != -1) {
			usuarios.set(index, usuario);
		}
		
		userFileManager.saveToFile(usuarios);
	}

	@Override
	public Usuario delete(Usuario usuario) {
		List<Usuario> usuarios = getAll();
		Usuario aux = null;
		
		int index = usuarios.indexOf(usuario);
		
		if(index != -1) {
			aux = usuarios.remove(index);
		}
		
		userFileManager.saveToFile(usuarios);

		return aux;
	}

	@Override
	public Usuario getByEmail(String email) {
		List<String> fileContents = userFileManager.getFileContents();
		Usuario user = null;
		
		for(String str : fileContents) {
			user = new Usuario();
			user.setDAT(str);
			
			if(user.getEmail().equals(email))
				return user;
		}
		
		return null;
	}
	
	private Long getNextId() {
		List<Usuario> usuarios = getAll();
		return Long.parseLong((usuarios.size() + 1) + "");
	}
}
