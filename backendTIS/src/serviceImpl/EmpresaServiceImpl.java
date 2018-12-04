package serviceImpl;

import java.util.List;

import DAO.EmpresaDAO;

import DAOImpl.EmpresaDAOImpl;

import model.Empresa;
import model.Evento;
import model.Startup;

import service.EmpresaService;
import service.EventoService;

import util.RNException;

public class EmpresaServiceImpl implements EmpresaService<Empresa, Startup, Evento, Long> {
	private EmpresaDAO<Empresa, Long> empresaDAO;
	private EventoService<Evento, Empresa, Long> eventoService;
	
	public EmpresaServiceImpl() {
		this.empresaDAO = new EmpresaDAOImpl ();
		this.eventoService = new EventoServiceImpl (); 
	}

	@Override
	public void criarEvento(Empresa empresa, Evento evento) throws RNException {
		this.eventoService.add(empresa, evento);
	}

	@Override
	public List<Startup> buscarStartups() throws RNException {
		return null;
	}

	@Override
	public Empresa getUsuario(Long id) throws RNException {
		return this.empresaDAO.get(id);
	}

	@Override
	public Empresa getUsuarioByEmail(String email) throws RNException {
		return this.empresaDAO.getByEmail(email);
	}

	@Override
	public void add(Empresa emp) throws RNException {
		
	}

	@Override
	public void update(Empresa emp) throws RNException {
		this.empresaDAO.update(emp);
	}

	@Override
	public Empresa delete(Long id) throws RNException {
		return this.empresaDAO.delete(this.getUsuario(id));
	}

	@Override
	public List<Empresa> getAll() throws RNException {
		return this.empresaDAO.getAll();
	}
}
