package ejercicio9.app;

import java.util.List;

import ejercicio9.modelo.Pelicula;
import ejercicio9.service.PeliculasXMLException;
import ejercicio9.service.XMLPeliculaService;

public class App {

	public static void main(String[] args) {
		testLeerXMLPeliculaSax();
	}

	private static void testLeerXMLPeliculaSax() {
		XMLPeliculaService service = new XMLPeliculaService();

		try {
			List<Pelicula> peliculas = service.leerPeliculas("c:/temporal/xmlLibros.xml");
			for (Pelicula pelicula : peliculas) {
				System.out.println(pelicula);
			}
		} catch (PeliculasXMLException e) {

			e.printStackTrace();
		}
	}

}
