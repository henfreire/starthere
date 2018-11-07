package util;

@SuppressWarnings("serial")
public class RNException extends Exception {
	private static final String PREFIX_ERROR_MESSAGE = "Viola��o da Regra de Neg�cio: ";
	private String error;
	
	public RNException(String error) {
		super(error);
		this.error = error;
	}
	
	@Override
	public String getMessage() {
		return PREFIX_ERROR_MESSAGE + this.error;
	}
	
}
