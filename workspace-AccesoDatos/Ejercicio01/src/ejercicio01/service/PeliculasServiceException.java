package ejercicio01.service;

public class PeliculasServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PeliculasServiceException() {
	}

	public PeliculasServiceException(String message) {
		super(message);

	}

	public PeliculasServiceException(Throwable cause) {
		super(cause);

	}

	public PeliculasServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public PeliculasServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
