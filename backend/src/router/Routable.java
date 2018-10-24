package router;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;

public interface Routable {
	
	public void sendRoute(String route, Request request, Response response);
	
}
