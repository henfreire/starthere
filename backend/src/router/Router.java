package router;

import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JOptionPane;

import org.json.JSONObject;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.Status;

public class Router implements IContainer, Routable {
	private static final String NON_POST_MESSAGE = "This server won't respond to non POST methods";
	
	private Request request;
	private Response response;
	
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
				this.setResponse(this.sendRoute(path, obj));
			} else {
				this.setResponse(Router.NON_POST_MESSAGE);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
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
	public String sendRoute(String route, JSONObject requestData) {
		String message = null;
		Routable router;
		
		if(route.startsWith("/usuario")) {
			route = route.replace("/usuario", "");
			router = new UsuarioRouter();
		} else if (route.startsWith("/evento")) {
			router = new EventoRouter();
		} else {
			router = null;
		}
		
		try {
			if(router != null) {
				message = router.sendRoute(route, requestData);
				this.setResponse(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return message;
	}
}
