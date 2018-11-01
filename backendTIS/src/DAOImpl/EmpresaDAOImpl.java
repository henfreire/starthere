package DAOImpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import DAO.EmpresaDAO;
import model.Empresa;

public class EmpresaDAOImpl implements EmpresaDAO<Empresa, Long> {
	private static final String FILE_NAME = "empresa.dat"; 
	
	public EmpresaDAOImpl () {}
	
	@Override
	public List<Empresa> getEmpresas() {
		List<Empresa> empresas = new ArrayList<Empresa>();
		Empresa empresa = null;
		String idSTR;

		try (DataInputStream entrada = new DataInputStream(new FileInputStream(FILE_NAME))) {
			while ((idSTR = entrada.readUTF()) != null) {
				empresa = new Empresa(Long.parseLong(idSTR));
				empresa.setEmail(entrada.readUTF());
				empresa.setNome(entrada.readUTF());
				empresa.setSenha(entrada.readUTF());
				
				empresas.add(empresa);
			}
		} catch(IOException e) { 
			System.out.println("ERRO ao ler o arquivo !");
			e.printStackTrace();
		}
		
		return empresas;
	}

	@Override
	public Empresa getEmpresa(Long id) {
		Empresa retorno = null;
		Empresa aux = null;
		String idSTR;

		try (DataInputStream entrada = new DataInputStream(new FileInputStream("bemduravel.dat"))) {
			while ((idSTR = entrada.readUTF()) != null) {
				aux = new Empresa(Long.parseLong(idSTR));
				aux.setEmail(entrada.readUTF());
				aux.setNome(entrada.readUTF());
				aux.setSenha(entrada.readUTF());
				
				if (id.equals(aux.getId())) {
					retorno = aux;
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("ERRO ao ler do arquivo do disco rígido!");
			e.printStackTrace();
		}
		return retorno;
	}

	@Override
	public void addEmpresa(Empresa empresa) {
		try (DataOutputStream saida = new DataOutputStream(new FileOutputStream(FILE_NAME, true))) {
			saida.writeLong(empresa.getId());
			saida.writeUTF(empresa.getNome());
			saida.writeUTF(empresa.getEmail());
			saida.writeUTF(empresa.getSenha());
			saida.flush();
		} catch (Exception e) {
			System.out.println(getErrorMessage(empresa.getNome()));
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmpresa(Empresa empresa) {
		List<Empresa> empresas = getEmpresas();
		int index = empresas.indexOf(empresa);
		if(index != -1) {
			empresas.set(index, empresa);
		}
		saveEmpresasToFile(empresas);
	}

	@Override
	public void deleteEmpresa(Empresa empresa) {
		List<Empresa> empresas = getEmpresas();
		int index = empresas.indexOf(empresa);
		if(index != -1) {
			empresas.remove(index);
		}
		saveEmpresasToFile(empresas);
	}

	private String getErrorMessage(String nomeEmpresa) {
		return "ERRO ao gravar valor para a empresa '" + nomeEmpresa + "' no disco!";
	}

	private void saveEmpresasToFile(List<Empresa> empresas) {
		try (DataOutputStream saida = 
			new DataOutputStream(new FileOutputStream(FILE_NAME, false))) {
			for (Empresa empresa : empresas) {
				saida.writeUTF(String.valueOf(empresa.getId()));
				saida.writeUTF(empresa.getNome());
				saida.writeUTF(empresa.getEmail());
				saida.writeUTF(empresa.getSenha());
				saida.flush();
			}
		} catch (Exception e) {
			System.out.println("ERRO ao gravar no disco!");
			e.printStackTrace();
		}
	}

	@Override
	public Long getNextId() {
		List<Empresa> empresas = getEmpresas();
		Empresa empresa = empresas.get(empresas.size());
		return empresa.getId() + 1;
	}
}
