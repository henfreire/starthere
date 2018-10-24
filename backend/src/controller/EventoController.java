package controller;

import org.json.JSONObject;

import service.EventoService;

public class EventoController {
	private EventoService evtService;
	
	public EventoController() {
		this.evtService = new EventoService ();
	}
	
	public void add(JSONObject obj) {
		String  nome = obj.getString("nome"),
				descricao = obj.getString("descricao"),
				data = obj.getString("data");
		long    idEmpresa = obj.getLong("idEmpresa");
		
		this.evtService.add(nome, descricao, data, idEmpresa);
	}

}
