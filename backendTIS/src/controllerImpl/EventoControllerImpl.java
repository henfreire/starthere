package controllerImpl;

import java.util.Date;
import java.util.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	private final String BRAZILIAN_DATE_FORMAT = "DD/MM/YYYY";
	
	public EventoControllerImpl() {
		this.evtService = new EventoServiceImpl ();
	}
	
	@Override
	public JSONObject sendRoute(String route, JSONObject requestData) {
		JSONObject result = new JSONObject ();
		
		if(route.startsWith("/add")) {
			result = this.add(requestData);
		} else if(route.startsWith("/getAll")) {
			result = this.getAll();
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
			
	        Date dataEvento = this.getDate(dataEventoStr);
	        
			Evento evento = new Evento ();
			evento.setNome(nome);
			evento.setDataEvento(dataEvento);
			evento.setDescricao(descricao);
			
			this.evtService.add(evento);
			
			result.put("evento", evento.toJSONObject());
		} catch (RNException e) {
			e.printStackTrace();
			result.put("RNException", e.getMessage());
		} catch(ParseException e) {
			e.printStackTrace();
			result.put("ParseException", e.getMessage());
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
	
	private Date getDate (String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(BRAZILIAN_DATE_FORMAT);
        return formatter.parse(date);
	}

	@Override
	public JSONObject delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
