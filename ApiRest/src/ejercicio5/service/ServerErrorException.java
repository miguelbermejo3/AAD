package ejercicio5.service;

public class ServerErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServerErrorException() {
		// TODO Auto-generated constructor stub
	}

	public ServerErrorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ServerErrorException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ServerErrorException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ServerErrorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
