package DAOImpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import DAO.EmpresaDAO;
import model.Empresa;

public class EmpresaDAOImpl implements EmpresaDAO<Empresa, String> {
	private static final String FILE_NAME = "empresa.dat"; 
	private List<Empresa> empresas;

	@Override
	public List<Empresa> getEmpresas() {
		List<Empresa> empresas = new ArrayList<Empresa>();
		Empresa empresa = null;
		String idSTR;

		try (DataInputStream entrada = new DataInputStream(new FileInputStream("bemduravel.dat"))) {
			while ((idSTR = entrada.readUTF()) != null) {
				empresa = new Empresa();
				empresa.setId(Long.parseLong(idSTR));
				empresa.setEmail(entrada.readUTF());
				empresa.setNome(entrada.readUTF());
				empresa.setSenha(entrada.readUTF());
				
				empresas.add(empresa);
			}
		} catch(EOFException e) { 
			System.out.println("ERRO ao ler o arquivo !");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ERRO ao ler o Bem de Consumo '" + empresa.getNome() + "' do disco rígido!");
			e.printStackTrace();
		}
		
		return empresas;
	}

	@Override
	public void getEmpresa(String chave) {
		
	}

	@Override
	public void addEmpresa(Empresa empresa) {
		try (DataOutputStream saida = new DataOutputStream(new FileOutputStream(EmpresaDAOImpl.FILE_NAME, true))) {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmpresa(Empresa empresa) {
		
	}

	private String getErrorMessage(String nomeEmpresa) {
		return "ERRO ao gravar valor para a empresa '" + nomeEmpresa + "' no disco!";
	}
	
}
