package router;

import java.io.IOException;
import java.io.PrintStream;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.Status;
import org.simpleframework.http.core.Container;

import controller.EmpresaController;
import controller.EventoController;
import controller.UsuarioController;

public class RouteController implements Container {
	private static final String NON_POST_MESSAGE = "This server won't respond to non POST methods";
	
	private Request request;
	private Response response;
	
	public void handle(Request request, Response response) {
		
		this.request = request;
		this.response = response;
		
		String path = request.getPath().getPath();
		String method = request.getMethod();

		try {
			if("POST".equals(method)) {
				this.sendRoute(path);
			} else {
				this.setResponse(RouteController.NON_POST_MESSAGE);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendRoute (String route) throws Exception {
		String message = null;
		Container router;
	
		if (route.startsWith("/empresa")) {
			router = new EmpresaRouter();
		} else if (route.startsWith("/evento")) {
			router = new EventoRouter();
		} else {
			throw new Exception("Invalid Route !");
		}
		
		router.handle(request, response);
		this.setResponse(message);
	 
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
	
}
