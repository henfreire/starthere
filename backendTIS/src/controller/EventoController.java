package controller;

import org.json.JSONObject;

import service.EventoService;

public class EventoController implements Routable {
	private EventoService evtService;
	
	public EventoController() {
		this.evtService = new EventoService ();
	}
	
	public void add(JSONObject obj) {
		String  nome = obj.getString("nome"),
				descricao = obj.getString("descricao"),
				data = obj.getString("dataEvento");
		long    idEmpresa = obj.getLong("idEmpresa");
		
		this.evtService.add(nome, descricao, data, idEmpresa);
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
