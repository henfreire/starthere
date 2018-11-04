package DAOImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import DAO.EmpresaDAO;
import model.Empresa;
import util.FileHandler;
import util.FileHandlerImpl;

public class EmpresaDAOImpl implements EmpresaDAO<Empresa, Long> {
	private static final String FILE_NAME = "empresa.dat"; 
	private FileHandler<Empresa> fileManager;
	
	public EmpresaDAOImpl () {
		fileManager = new FileHandlerImpl<Empresa>(FILE_NAME);
	}
	
	public List<Empresa> getAll() {
		List<Empresa> empresas = new ArrayList<Empresa>();
		List<String> fileContents;
		Empresa empresa = null;
		fileContents = fileManager.getFileContents();
		
		Iterator<String> itStr = fileContents.iterator();
		while(itStr.hasNext()) {
			empresa = new Empresa();
			empresa.setId(Long.parseLong(itStr.next()));
			empresa.setNome(itStr.next());
			empresa.setEmail(itStr.next());
			empresa.setSenha(itStr.next());
			
			empresas.add(empresa);
		}
			
		return empresas;
	}

	@Override
	public Empresa get(Long id) {
		List<Empresa> empresas = getAll();
		
		return  empresas.stream()
				.filter(empresa -> empresa.getId().equals(id))
				.collect(Collectors.toList())
				.get(0);		
	}

	@Override
	public void add(Empresa empresa) {
		Long id = getNextId();
		empresa.setId(id);
		fileManager.saveToFile(empresa);
	}

	@Override
	public void update(Empresa empresa) {
		List<Empresa> empresas = getAll();

		int index = empresas.indexOf(empresa);
		if(index != -1) {
			empresas.set(index, empresa);
		}
		
	}

	@Override
	public Empresa delete(Empresa empresa) {
		List<Empresa> empresas = getAll();
		Empresa aux = null;
		
		int index = empresas.indexOf(empresa);
		
		if(index != -1) {
			aux = empresas.remove(index);
		}
		
		saveEmpresasToFile(empresas);
		
		return aux;
	}

	private void saveEmpresasToFile(List<Empresa> empresas) {
		fileManager.saveToFile(empresas);	
	}

	@Override
	public Empresa getByEmail(String nome) {
		List<String> fileContents = fileManager.getFileContents();
		Empresa empresa = null;

		Iterator<String> itStr = fileContents.iterator();
		
		while(itStr.hasNext()) {
			empresa = new Empresa();
			empresa.setId(Long.parseLong(itStr.next()));
			empresa.setNome(itStr.next());
			empresa.setEmail(itStr.next());
			empresa.setSenha(itStr.next());
			
			if(empresa.getEmail().equals(nome))
				break;
		}
				
		return empresa;
	}
	
	private Long getNextId() {
		List<Empresa> empresas = getAll();
		return Long.parseLong(empresas.size() + "");
	}
}
