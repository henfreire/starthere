package DAOImpl;

import DAO.EmpresaDAO;
import model.Empresa;
import util.FileHandlerImpl;

public class EmpresaDAOImpl extends UsuarioDAOImpl<Empresa> implements EmpresaDAO<Empresa, Long> {
	private static final String FILE_NAME = "empresa.dat"; 
	
	public EmpresaDAOImpl() {
		this.fileManager = new FileHandlerImpl<Empresa>(FILE_NAME);
	}	
}
