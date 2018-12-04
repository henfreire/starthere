package controllerImpl;

import controller.IUsuarioControllerFactory;
import controller.UsuarioController;

public class UsuarioControllerFactory implements IUsuarioControllerFactory {
	public static final String EMPRESA_ID = "Emp";
	public static final String STARTUP_ID = "Stp";
	public static final String INVESTIDOR_ID = "Inv";
	
	private final String ERROR_MESSAGE = "Controller not found !";
	
	@Override
	public UsuarioController getController(String key) throws ControllerException {
		if(key != null) {
			if(key.equals(EMPRESA_ID)) {
				return new EmpresaControllerImpl ();
			} else if(key.equals(STARTUP_ID)) {
				return new StartupControllerImpl ();
			} else if(key.equals(INVESTIDOR_ID)) {
				return new InvestidorControllerImpl ();
			}
		}
		
		throw new ControllerException(ERROR_MESSAGE);
	}
}
