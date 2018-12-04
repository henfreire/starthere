package controllerImpl;

import org.json.JSONObject;

public class InvestidorControllerImpl extends UsuarioControllerImpl {
	
	public InvestidorControllerImpl() {
//		new InvestidorServiceImpl();
	}

	@Override
	public JSONObject sendRoute(String route, JSONObject data) {
		JSONObject result = new JSONObject ();
		
		try {
			if(route.startsWith("/add")) {			
				result = this.add(data);
			} else if(route.startsWith("/getAll")) {
				this.getAll().toString();
			}  else {
				throw new Exception("Rota inválida !");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("error", e.getMessage());
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
}
