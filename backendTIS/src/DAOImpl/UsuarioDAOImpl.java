package DAOImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import DAO.UsuarioDAO;
import model.Usuario;
import util.FileHandler;

public abstract class UsuarioDAOImpl<E extends Usuario> implements UsuarioDAO<E, Long> {
	protected FileHandler<E> fileManager;
	
	public List<E> getAll() {
		List<E> empresas = new ArrayList<E>();
		List<String> fileContents;
		String  str, 
				vet[];
		E empresa = null;
		fileContents = fileManager.getFileContents();
		
		Iterator<String> itStr = fileContents.iterator();
		while(itStr.hasNext()) {
			str = itStr.next();
			vet = str.split("[|]");
			
			empresa = (E) new Usuario();
			empresa.setId(Long.parseLong(vet[0]));
			empresa.setNome(vet[1]);
			empresa.setEmail(vet[2]);
			empresa.setSenha(vet[3]);
			
			empresas.add(empresa);
		}
			
		return empresas;
	}

	@Override
	public E get(Long id) {
		List<E> empresas = getAll();
		
		return  empresas.stream()
				.filter(empresa -> empresa.getId().equals(id))
				.collect(Collectors.toList())
				.get(0);		
	}

	@Override
	public void add(E empresa) {
		Long id = getNextId();
		empresa.setId(id);
		fileManager.saveToFile(empresa);
	}

	@Override
	public void update(E empresa) {
		List<E> empresas = getAll();

		int index = empresas.indexOf(empresa);
		if(index != -1) {
			empresas.set(index, empresa);
		}
		
	}

	@Override
	public E delete(E empresa) {
		List<E> empresas = getAll();
		E aux = null;
		
		int index = empresas.indexOf(empresa);
		
		if(index != -1) {
			aux = empresas.remove(index);
		}
		
		saveEmpresasToFile(empresas);

		return aux;
	}

	private void saveEmpresasToFile(List<E> empresas) {
		fileManager.saveToFile(empresas);	
	}

	@Override
	public E getByEmail(String email) {
		List<String> fileContents = fileManager.getFileContents();
		E user = null;
		String str, vet[];
		
		Iterator<String> itStr = fileContents.iterator();
				
		while(itStr.hasNext()) {
			str = itStr.next();
			vet = str.split("[|]");

			user = (E) new Usuario();
			
			user.setId(Long.parseLong(vet[0]));
			user.setNome(vet[1]);
			user.setSenha(vet[2]);
			user.setEmail(vet[3]);
			
			if(user.getEmail().equals(email))
				break;
			else 
				user = null;
		}
		
		return user;
	}
	
	private Long getNextId() {
		List<E> empresas = getAll();
		return Long.parseLong(empresas.size() + "");
	}
}
