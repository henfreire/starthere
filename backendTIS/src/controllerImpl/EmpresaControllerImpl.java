package controllerImpl;

import org.json.JSONObject;

import controller.EmpresaController;
import controller.AbstractUsuarioController;

import serviceImpl.EmpresaServiceImpl;
import serviceImpl.EventoServiceImpl;
import util.RNException;

import service.EmpresaService;
import service.EventoService;

import model.Empresa;
import model.Startup;
import model.Evento;

public class EmpresaControllerImpl extends AbstractUsuarioController<Empresa> implements EmpresaController {
	private EmpresaService<Empresa, Startup, Evento, Long> empresaService;
	private EventoService<Evento, Empresa, Long> evtService;
	
	public EmpresaControllerImpl () {
		this.empresaService = new EmpresaServiceImpl ();
		this.evtService = new EventoServiceImpl ();
	}	
	
	@Override
	public JSONObject sendRoute(String route, JSONObject requestData) {
		JSONObject result = null;
		
		if(route.startsWith("/addEvento")) {
			result = this.addEvento(requestData);
		} else {
			return super.sendRoute(route, requestData);
		}
		
		return result;
	}

	@Override
	public JSONObject addEvento(JSONObject obj) {
		JSONObject result = new JSONObject ();		
		String  nome,
				descricao,
				dataEvento;
		Long id;
		
		try {
			id = Long.parseLong(obj.getString("idEmpresa"));
			nome = obj.getString("nome");
			descricao = obj.getString("descricao");
			dataEvento = obj.getString("dataEvento");
			
			Evento evento = new Evento ();
			
			evento.setNome(nome);
			evento.setDataEvento(dataEvento);
			evento.setDescricao(descricao);
			
			Empresa emp = new Empresa ();
			emp.setId(id);
			
			this.evtService.add(emp, evento);
			
			result.put("evento", evento.toJSONObject());
		} catch (RNException e) {
			e.printStackTrace();
			result.put("RNException", e.getMessage());
		}
		
		return result;
	}

	public JSONObject add(JSONObject obj) {
		JSONObject result = new JSONObject();
		String email = obj.getString("email"),
			   senha = obj.getString("senha"),
			   nome  = obj.getString("nome");
		
		Empresa newEmpresa = new Empresa ();

		newEmpresa.setNome(nome);
		newEmpresa.setEmail(email);
		newEmpresa.setSenha(senha);
		
		try {
			this.empresaService.add(newEmpresa);
			result.append("empresa", newEmpresa.toJSONObject());
		} catch (RNException e) {
			e.printStackTrace();
			result.put("RNException", e.getMessage());
		}
		
		return result;
	}

	@Override
	public JSONObject update(JSONObject obj) {
		return null;
	}

	@Override
	public JSONObject delete(long id) {
		return null;
	}

	@Override
	public JSONObject get(JSONObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
