package DAOImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import DAO.UsuarioDAO;
import model.Usuario;
import util.FileHandler;
import util.FileHandlerImpl;

public class UsuarioDAOImpl implements UsuarioDAO<Usuario> {
	private final String FILE_NAME = "usuarios.dat"; 
	private FileHandler<Usuario> fileManager;
	private static Long NEXT_ID = 1L;
	
	UsuarioDAOImpl() {
		this.fileManager = new FileHandlerImpl<Usuario> (this.FILE_NAME);
	}
	
	UsuarioDAOImpl(String fileName) {
		this.fileManager = new FileHandlerImpl<Usuario> (fileName);
	}
	
	@Override
	public List<Usuario> getAll() {
		List<Usuario> usuarios = new ArrayList<Usuario> ();
		List<String> fileContents;
		Iterator<String> itStr;
		String  str;
		Usuario usuario = null;
		
		fileContents = fileManager.getFileContents();
		
		itStr = fileContents.iterator();
		
		while(itStr.hasNext()) {
			str = itStr.next();
			
			usuario = new Usuario();
			usuario.setDAT(str);
			usuarios.add(usuario);
		}
			
		return usuarios;
	}

	@Override
	public Usuario get(Long id) {
		List<Usuario> usuarios = getAll();
		
		return  usuarios.stream()
				.filter(usuario -> usuario.getId().equals(id))
				.collect(Collectors.toList())
				.get(0);		
	}

	@Override
	public void add(Usuario usuario) {
		usuario.setId(getNextId());
		this.fileManager.saveToFile(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		List<Usuario> usuarios = getAll();

		int index = usuarios.indexOf(usuario);
		if(index != -1) {
			usuarios.set(index, usuario);
		}
		
		this.fileManager.saveToFile(usuarios);
	}

	@Override
	public Usuario delete(Usuario usuario) {
		List<Usuario> usuarios = getAll();
		Usuario aux = null;
		
		int index = usuarios.indexOf(usuario);
		
		if(index != -1) {
			aux = usuarios.remove(index);
		}
		
		this.fileManager.saveToFile(usuarios);

		return aux;
	}

	@Override
	public Usuario getByEmail(String email) {
		List<String> fileContents = fileManager.getFileContents();
		Usuario usuario = null;
		String str;
		
		Iterator<String> itStr = fileContents.iterator();
				
		while(itStr.hasNext()) {
			str = itStr.next();

			usuario = new Usuario();			
			usuario.setDAT(str);
			if(usuario.getEmail().equals(email)) 
				break;
			
			usuario = null;
		}
		
		return usuario;
	}
	
	public Long getNextId() {
		List<Usuario> usuarios = getAll();
		Long lastId = usuarios.get(usuarios.size() - 1).getId();

		NEXT_ID = (lastId == null)
				? 1L
				: (lastId + 1);

		return NEXT_ID;
	}
}
