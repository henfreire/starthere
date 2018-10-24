package router;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;

import controller.EmpresaController;

public class EmpresaRouter implements Routable {
	private EmpresaController empController;
	
	public EmpresaRouter () {
		this.empController = new EmpresaController ();
	}
	
	@Override
	public void sendRoute(String route, Request request, Response response) {
		if(route.startsWith("/add")) {
			String nome = request.getParameter("name");
			String senha = request.getParameter("senha");
			
			try {
				this.empController.add(nome, senha, "jesus@gmail.com");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(route.startsWith("/getAll")) {
			response.addValue("helpme", this.empController.getAll().toString());
		}
	}

}
