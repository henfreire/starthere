package router;

import org.json.JSONObject;

import controller.EventoController;

public class EventoRouter implements Routable {
	public EventoController evtController; 
	
	public EventoRouter () {
		evtController = new EventoController();
	}
	
	@Override
	public String sendRoute(String route, JSONObject requestData) {
		String result = null;
		
		if(route.startsWith("/add")) {
			EventoRouter e = new EventoRouter(); 
			this.evtController.add(requestData);
			result = "O registro foi salvo com sucesso !";
		} else {
			result = "Ocorreu um erro inseperador";
		}
		
		return result;
	}


}
