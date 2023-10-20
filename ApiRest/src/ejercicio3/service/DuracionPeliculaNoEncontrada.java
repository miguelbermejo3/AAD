package ejercicio3.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class DuracionPeliculaNoEncontrada extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuracionPeliculaNoEncontrada() {
		// TODO Auto-generated constructor stub
	}

	public DuracionPeliculaNoEncontrada(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DuracionPeliculaNoEncontrada(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DuracionPeliculaNoEncontrada(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DuracionPeliculaNoEncontrada(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
