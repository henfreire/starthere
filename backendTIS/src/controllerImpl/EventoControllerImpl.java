package controllerImpl;

import org.json.JSONObject;

import controller.EventoController;
import model.Empresa;
import model.Evento;
import service.EventoService;
import serviceImpl.EventoServiceImpl;

public class EventoControllerImpl implements EventoController {
	private EventoService<Evento, Empresa, Long> evtService;
	
	public EventoControllerImpl() {
		this.evtService = new EventoServiceImpl ();
	}
	
	public void add(JSONObject obj) {
		String  nome = obj.getString("nome"),
				descricao = obj.getString("descricao"),
				data = obj.getString("dataEvento");
		long    idEmpresa = obj.getLong("idEmpresa");
		
//		Evento evento = new Evento (data, null);
		
		this.evtService.add(evento);
	}

	@Override
	public JSONObject sendRoute(String route, JSONObject requestData) {
		String result = null;
		
		if(route.startsWith("/add")) {
//			this.evtService.add(requestData);
			result = "O registro foi salvo com sucesso !";
		} else {
			result = "Ocorreu um erro inseperador";
		}
		
		return null;
	}
}
