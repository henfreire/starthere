package controllerImpl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.Routable;

import model.Empresa;
import model.Evento;

import service.EventoService;

import serviceImpl.EventoServiceImpl;

import util.RNException;

public class EventoControllerImpl implements Routable {
	private EventoService<Evento, Empresa, Long> evtService;
	
	public EventoControllerImpl() {
		this.evtService = new EventoServiceImpl ();
	}
	
	@Override
	public JSONObject sendRoute(String route, JSONObject requestData) {
		JSONObject result = new JSONObject ();
		
		if(route.startsWith("/getAll")) {
			result = this.getAll();
		} else {
			result.put("error", "Esta rota não existe !");
		}
		
		return result;
	}

	public JSONObject getAll() {
		List<Evento> eventos;
		JSONObject result = new JSONObject();
		JSONArray array = new JSONArray();
		
		try {
			eventos = this.evtService.getAll();
			
			if(eventos != null) {
				eventos .stream()
						.forEach(evt -> array.put(evt.toJSONObject()));
			}
			
			result.put("eventos", array);
		} catch (RNException e) {
			e.printStackTrace();
			result.put("RNException", e.getMessage());
		}
		
		return result;
	}
}
