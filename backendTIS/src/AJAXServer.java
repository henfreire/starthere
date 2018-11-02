import java.io.IOException;
import java.io.PrintStream;

import org.json.JSONObject;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.Status;
import org.simpleframework.http.core.Container;

import controller.EmpresaController;
import controller.EventoController;
import controller.InvestidorController;
import controller.LoginController;
import controller.Routable;
import controller.StartupController;

public class AJAXServer implements Container, Routable {
	private static final String NON_POST_MESSAGE = "Este servidor não irá responder a métodos que não são POST";
	
	private Request request;
	private Response response;

	AJAXServer () {}	
	
	public void handle(Request request, Response response) {
		this.request = request;
		this.response = response;
		
		String path = this.request.getPath().getPath();
		String method = this.request.getMethod();
		
		Query query = this.request.getQuery();
		JSONObject obj = new JSONObject ();
		
		try {
			Object[] keys = query.keySet().toArray();
			
			for(int i = 0 ; i < keys.length; i++) {
				obj.put(keys[i].toString(), query.get(keys[i]));
			}
			
			if("POST".equals(method)) {
				this.setResponse(this.sendRoute(path, obj).toString());
			} else {
				this.setResponse(AJAXServer.NON_POST_MESSAGE);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setResponse(String message) throws IOException {
		PrintStream body = this.response.getPrintStream();
		long time = System.currentTimeMillis();

		this.response.setValue("Content-Type", "application/json");
		this.response.setValue("Server", "Controle de EstoqueService (1.0)");
		this.response.setValue("Access-Control-Allow-Origin", "null");
		this.response.setDate("Date", time);
		this.response.setDate("Last-Modified", time);
		this.response.setStatus(Status.OK);

		if (message != null)
			body.println(message);
		body.close();
	}

	@Override
	public JSONObject sendRoute(String route, JSONObject requestData) {
		JSONObject result = null;
		Routable router;
		
		if(route.startsWith("/login")) {
			route = route.replace("/login", "");
			router = new LoginController();
		} else if (route.startsWith("/evento")) {
			route = route.replace("/evento", "");
			router = new EventoController();
		} else if (route.startsWith("/empresa")) {
			route = route.replaceAll("/empresa", "");
			router = new EmpresaController();
		} else if (route.startsWith("/startup")) {
			route = route.replaceAll("/startup", "");
			router = new StartupController();
		} else if (route.startsWith("/investidor")) {
			route = route.replaceAll("/investidor", "");
			router = new InvestidorController();
		} else {
			router = null;
		}
		
		try {
			if(router != null) {
				result = router.sendRoute(route, requestData);
				// JOptionPane.showMessageDialog(null, result);
				this.setResponse(result.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
