package controllerImpl;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.EventoController;

import model.Empresa;
import model.Evento;
import service.EventoService;
import serviceImpl.EventoServiceImpl;

import util.RNException;

public class EventoControllerImpl implements EventoController {
	private EventoService<Evento, Empresa, Long> evtService;
	
	public EventoControllerImpl() {
		this.evtService = new EventoServiceImpl ();
	}
	
	@Override
	public JSONObject sendRoute(String route, JSONObject requestData) {
		JSONObject result = new JSONObject ();
		
		if(route.startsWith("/add")) {
			result.put("evento", this.add(requestData));
		} else {
			result.put("error", "Esta rota não existe !");
		}
		
		return result;
	}

	@Override
	public JSONObject add(JSONObject obj) {
		JSONObject result = new JSONObject ();
		String  nome,
				descricao,
				dataEventoStr;
		try {
			nome = obj.getString("nome");
			descricao = obj.getString("descricao");
			dataEventoStr = obj.getString("dataEvento");
			
			SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
	        
	        Date dataEvento = formatter.parse(dataEventoStr);
	            
			Evento evento = new Evento ();
			evento.setNome(nome);
			evento.setDataEvento(dataEvento);
			evento.setDescricao(descricao);
			
			this.evtService.add(evento);
		} catch (RNException e) {
			e.printStackTrace();
			result.put("RNException", e.getMessage());
		} catch(ParseException e) {
			e.printStackTrace();
			result.put("error", e.getMessage());
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
		return null;
	}

	@Override
	public JSONArray getAll() {
		return null;
	}
}
