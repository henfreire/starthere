package controllerImpl;

import controller.ControllerException;
import controller.RouterFactory;
import controller.Routable;

public class RouterFactoryImpl implements RouterFactory {
	public static final String EMPRESA_ID = "/empresa";
	public static final String STARTUP_ID = "/startup";
	public static final String INVESTIDOR_ID = "/investidor";
	public static final String LAMENTACAO_ID = "/lamentacao";
	public static final String EVENTO_ID = "/evento";
	public static final String LOGIN_ID = "/login";
	
	private final String ERROR_MESSAGE = "A rota informada não existe !";
	
	@Override
	public Routable getRouter(String routerId) throws ControllerException {
		if(routerId != null) {
			switch (routerId) {
		 		case EMPRESA_ID :
		 			return new EmpresaControllerImpl ();
				case STARTUP_ID :
					return new StartupControllerImpl ();
				case INVESTIDOR_ID :
					return new InvestidorControllerImpl ();
				case LAMENTACAO_ID :
					return new LamentacaoControllerImpl ();
				case EVENTO_ID :
					return new EventoControllerImpl ();
				case LOGIN_ID :
					return new LoginControllerImpl ();
				default :
					break;
		 	}
		}
		
		throw new ControllerException(ERROR_MESSAGE);
	}
}
