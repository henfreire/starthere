package controllerImpl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.CRUDRoutableController;

import model.Empresa;
import model.Evento;
import service.EventoService;
import serviceImpl.EventoServiceImpl;

import util.RNException;

public class EventoControllerImpl implements CRUDRoutableController {
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

	@Override
	public JSONObject update(JSONObject obj) {
		return null;
	}
	
	@Override
	public JSONObject get(JSONObject obj) {
		return null;
	}

	@Override
	public JSONObject getAll() {
		List<Evento> eventos;
		JSONObject result = new JSONObject();
		JSONArray array = new JSONArray();
		
		try {
			eventos = this.evtService.getAll();
			
			if(eventos != null) {
				eventos.stream().forEach(evt -> array.put(evt.toJSONObject()));
			}
			
			result.put("eventos", array);
		} catch (RNException e) {
			e.printStackTrace();
			result.put("RNException", e.getMessage());
		}
		
		return result;
	}

	@Override
	public JSONObject delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject add(JSONObject obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
