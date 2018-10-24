package router;

import javax.swing.JOptionPane;

import org.json.JSONObject;

import controller.InvestidorController;

public class InvestidorRouter implements Routable {
	private InvestidorController invController;
	
	public InvestidorRouter () {
		this.invController = new InvestidorController ();
	}
	
	@Override
	public String sendRoute(String route, JSONObject data) {
		String result = null;
		
		JOptionPane.showMessageDialog(null, route);
		
		if(route.startsWith("/add")) {			
			try {
				this.invController.add(this.invController.getService(), data);
				result = "O registro foi salvo com sucesso !";
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else if(route.startsWith("/getAll")) {
			result = this.invController.getAll().toString();
		}  else {
			result = null;
		}
		
		return result;
	}

}
