package ejercicio3.service;

public class PagosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PagosException() {
	}

	public PagosException(String message) {
		super(message);

	}

	public PagosException(Throwable cause) {
		super(cause);

	}

	public PagosException(String message, Throwable cause) {
		super(message, cause);

	}

	public PagosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
