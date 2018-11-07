package mainServer;

import java.io.IOException;
import java.io.PrintStream;

import org.json.JSONObject;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.Status;
import org.simpleframework.http.core.Container;

import controller.Routable;

import controllerImpl.EmpresaControllerImpl;
import controllerImpl.EventoControllerImpl;
import controllerImpl.InvestidorControllerImpl;
import controllerImpl.LoginControllerImpl;
import controllerImpl.StartupControllerImpl;

public class AJAXServer implements Container, Routable {
	private Request request;
	private Response response;

	AJAXServer () {}	
	
	@Override
	public void handle(Request request, Response response) {
		this.request = request;
		this.response = response;
		
		String path = this.request.getPath().getPath();
		Query query = this.request.getQuery();
		JSONObject obj = new JSONObject ();
		
		try {
			Object[] keys = query.keySet().toArray();
			
			for(int i = 0 ; i < keys.length; i++) {
				obj.put(keys[i].toString(), query.get(keys[i]));
			}
			
			this.setResponse(this.sendRoute(path, obj).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public JSONObject sendRoute(String route, JSONObject requestData) {
		JSONObject result = new JSONObject ();
		Routable router;
		
		if(route.startsWith("/login")) {
			route = route.replace("/login", "");
			router = new LoginControllerImpl();
		} else if (route.startsWith("/evento")) {
			route = route.replace("/evento", "");
			router = new EventoControllerImpl();
		} else if (route.startsWith("/empresa")) {
			route = route.replaceAll("/empresa", "");
			router = new EmpresaControllerImpl();
		} else if (route.startsWith("/startup")) {
			route = route.replaceAll("/startup", "");
			router = new StartupControllerImpl();
		} else if (route.startsWith("/investidor")) {
			route = route.replaceAll("/investidor", "");
			router = new InvestidorControllerImpl();
		} else {
			router = null;
		}
		
		try {
			if(router != null) {
				result = router.sendRoute(route, requestData);
				this.setResponse(result.toString());
			} else {
				throw new Exception("Essa rota não existe !");
			}
		} catch (IOException e) {
			e.printStackTrace();
			result.put("error", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			result.put("error", e.getMessage());
		}
		
		return result;
	}
		
	private void setResponse(String message) throws IOException {
		PrintStream body = this.response.getPrintStream();
		long time = System.currentTimeMillis();

		this.response.setValue("Content-Type", "application/json; charset=utf-8");
		this.response.setValue("Server", "StartHere v0.0.1");
		this.response.setValue("Access-Control-Allow-Origin", "null");
		this.response.setDate("Date", time);
		this.response.setDate("Last-Modified", time);
		this.response.setStatus(Status.OK);

		if (message != null)
			body.println(message);
		
		body.close();
	}

}
