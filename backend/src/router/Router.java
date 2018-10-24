package router;

import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JOptionPane;

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
		
		String path = request.getPath().getPath();
		String method = request.getMethod();

		try {
			if("POST".equals(method)) {
				this.sendRoute(path, request, response);
			} else {
				this.setResponse(Router.NON_POST_MESSAGE);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendRoute (String route, Request request, Response response) {
		String message = null;
		Routable router;
		
		if (route.startsWith("/empresa")) {
			route = route.replaceAll("/empresa", "");
			router = new EmpresaRouter();
		} else if (route.startsWith("/startup")) {
			router = new StartUpRouter();
		} else if (route.startsWith("/investidor")) {
			router = new InvestidorRouter();
		} else if (route.startsWith("/evento")) {
			router = new EventoRouter();
		} else {
			router = null;
		}
		
		try {
			if(router != null) {
				router.sendRoute(route, request, response);
				this.setResponse(message);
			}
		} catch (IOException e) {
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
}
