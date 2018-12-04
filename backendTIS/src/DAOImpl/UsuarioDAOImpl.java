package DAOImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DAO.UsuarioDAO;
import model.Usuario;
import util.FileHandler;
import util.FileHandlerImpl;

public class UsuarioDAOImpl implements UsuarioDAO<Usuario, Long> {
	private FileHandler<Usuario> fileManager;
	
	public UsuarioDAOImpl(String fileName) {
		this.fileManager = new FileHandlerImpl<Usuario> (fileName);
	}
	
	public List<Usuario> getAll() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		List<String> fileContents = fileManager.getFileContents();
		Iterator<String> itStr = fileContents.iterator();
		String  str;
		Usuario usuario = null;
		
		while(itStr.hasNext()) {
			str = itStr.next();
			
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
	public void add(Usuario empresa) {
		empresa.setId(getNextId());
		fileManager.saveToFile(empresa);
	}

	@Override
	public void update(Usuario empresa) {
		List<Usuario> empresas = getAll();

		int index = empresas.indexOf(empresa);
		
		if(index != -1) {
			empresas.set(index, empresa);
		}
		
	}

	@Override
	public Usuario delete(Usuario usuario) {
		List<Usuario> usuarios = getAll();
		Usuario aux = null;
		
		int index = usuarios.indexOf(usuario);
		
		if(index != -1) {
			aux = usuarios.remove(index);
		}
		
		saveEmpresasToFile(usuarios);

		return aux;
	}

	private void saveEmpresasToFile(List<Usuario> empresas) {
		fileManager.saveToFile(empresas);	
	}

	@Override
	public Usuario getByEmail(String email) {
		List<String> fileContents = fileManager.getFileContents();
		Usuario user = null;
		String str = null;
		
		Iterator<String> itStr = fileContents.iterator();
				
		while(itStr.hasNext()) {
			str = itStr.next();

			user = new Usuario();

			user.setDAT(str);
			
			if(user.getEmail().equals(email))
				break;
		}
		
		return user;
	}
	
	private Long getNextId() {
		List<Usuario> usuarios = getAll();
		return Long.parseLong((usuarios.size() + 1) + "");
	}
}
