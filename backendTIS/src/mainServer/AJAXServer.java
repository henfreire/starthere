package mainServer;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.json.JSONObject;
import org.simpleframework.http.Part;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.Status;
import org.simpleframework.http.core.Container;

import controller.ControllerException;
import controller.Routable;
import controller.RouterFactory;
import controllerImpl.RouterFactoryImpl;

public class AJAXServer implements Container, Routable {
	private Request request;
	private Response response;

	AJAXServer () {}	
	
	@Override
	public void handle(Request request, Response response) {
		this.request = request;
		this.response = response;

		try {
			String path = this.request.getPath().getPath();
			Query query = this.request.getQuery();
			JSONObject obj = new JSONObject ();
			
			List<Part> list = request.getParts();
			
			list.stream().forEach(l -> {
				try {
					obj.put(l.getName(), l.getContent());
					System.out.println(l.getName() + " -> " + l.getContent());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
			Object[] keys = query.keySet().toArray();
			
			for(int i = 0 ; i < keys.length; i++) {
				obj.put(keys[i].toString(), query.get(keys[i]));
			}
			
			System.out.println(obj);

			this.setResponse(this.sendRoute(path, obj).toString());
		} catch (Exception e) {
			e.printStackTrace();
			this.setResponse("Ocorreu um erro insesperado ");
		}
	}

	@Override
	public JSONObject sendRoute(String route, JSONObject requestData) {
		JSONObject result = new JSONObject ();
		Routable router = null;
		
		try {
			RouterFactory factory = new RouterFactoryImpl ();

			String controllerId = "/" + route.split("/")[1];
			String controllerMethod = "";

			if(!controllerId.equals("/login"))
				controllerMethod = "/" + route.split("/")[2];
			
			router = factory.getRouter(controllerId);
			result = router.sendRoute(controllerMethod, requestData);
			
			this.setResponse(result.toString());
		} catch (ControllerException e) {
			e.printStackTrace();
			result.put("error", e.getMessage());
		}
		
		return result;
	}
		
	private void setResponse(String message) {
		PrintStream body;
		try {
			body = this.response.getPrintStream();
		
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
