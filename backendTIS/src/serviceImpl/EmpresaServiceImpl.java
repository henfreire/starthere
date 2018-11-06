package serviceImpl;

import java.util.List;

import DAOImpl.EmpresaDAOImpl;
import model.Empresa;
import model.Evento;
import model.Startup;
import service.EmpresaService;
import util.RNException;

public class EmpresaServiceImpl extends UsuarioServiceImpl<Empresa> implements EmpresaService<Empresa, Startup, Evento, Long> {
	public EmpresaServiceImpl() {
		this.usrDAO = new EmpresaDAOImpl();
	}

	@Override
	public void criarEvento(Evento evento) throws RNException {
	}

	@Override
	public List<Startup> buscarStartups() throws RNException {
		return null;
	}

}
