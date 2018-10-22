package controller;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;

public interface Routable {

	public void handle(Request request, Response response);	

}
