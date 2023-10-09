package ejercicio01.app;

import java.util.List;

import ejercicio01.modelo.Pelicula;
import ejercicio01.service.PeliculaService;
import ejercicio01.service.PeliculasServiceException;

public class App {

	public App() {
	}

	public static void main(String[] args)  {

		PeliculaService ps = new PeliculaService();
		try {
			List<Pelicula>peliculas = ps.consultarPeliculas();
			for (Pelicula pelicula : peliculas) {
				System.out.println(pelicula);
			}
			
		} catch (PeliculasServiceException e) {
			
			e.printStackTrace();
		}

	}

}
