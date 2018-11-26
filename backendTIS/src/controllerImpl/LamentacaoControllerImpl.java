package controllerImpl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.RoutableCRUD;
import model.Lamentacao;
import service.LamentacaoService;

public class LamentacaoControllerImpl implements RoutableCRUD {
	private LamentacaoService lamDAO;
	
	@Override
	public JSONObject sendRoute(String route, JSONObject requestData) {
		return null;
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
		return null;
	}

	@Override
	public JSONObject getAll() {
		List<Lamentacao> lamentacoes = this.lamDAO.getAll();
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();
		
		lamentacoes.stream().forEach(lam -> arr.put(lam.toJSONObject()));
		
		obj.put("lamentacoes", arr);
		
		return obj;
	}

}
