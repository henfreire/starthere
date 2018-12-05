package controllerImpl;

import org.json.JSONObject;

import controller.LamentacaoController;

public class LamentacaoControllerImpl implements LamentacaoController {

	@Override
	public JSONObject sendRoute(String route, JSONObject requestData) {
		JSONObject result = new JSONObject ();
		
		if(route.startsWith("/getAll")) {
			result = this.getAll();
		} else if(route.startsWith("/add")) {
			result = this.add(requestData);
		} else {
			result.put("error", "Esta rota não existe !");
		}
		
		return result;
	}

	@Override
	public JSONObject add(JSONObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject update(JSONObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject delete(long id) {
		// TODO Auto-generated method stub
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
