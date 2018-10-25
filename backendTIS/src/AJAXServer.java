import java.io.PrintStream;

import javax.swing.JOptionPane;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.Status;
import org.simpleframework.http.core.Container;

import router.Router;

public class AJAXServer implements Container {
	
	AJAXServer () {}
	
	public void handle(Request request, Response response) {
		try {
			new Router().handle(request, response);
		} catch (Exception e) {
			try {
				this.enviaResposta(Status.BAD_REQUEST, response, e.getMessage());
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "O servidor encontrou um problema ao responder uma requisição.");
			}
		}
	}
	
	private void enviaResposta(Status status, Response response, String message) throws Exception {
		PrintStream body = response.getPrintStream();
		long time = System.currentTimeMillis();

		response.setValue("Content-Type", "application/json");
		response.setValue("Server", "Controle de EstoqueService (1.0)");
		response.setValue("Access-Control-Allow-Origin", "null");
		response.setDate("Date", time);
		response.setDate("Last-Modified", time);
		response.setStatus(status);

		if (message != null)
			body.println(message);
		body.close();
	}

}
