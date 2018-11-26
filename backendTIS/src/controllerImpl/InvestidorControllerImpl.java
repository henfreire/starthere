package controllerImpl;

import org.json.JSONObject;

import controller.RoutableCRUD;
import model.Investidor;
import serviceImpl.InvestidorServiceImpl;

public class InvestidorControllerImpl extends UsuarioControllerImpl<Investidor> implements RoutableCRUD {
	
	public InvestidorControllerImpl() {
		this.service = new InvestidorServiceImpl();
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
}
