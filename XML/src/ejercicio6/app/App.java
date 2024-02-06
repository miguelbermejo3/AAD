package ejercicio6.app;

import java.util.List;

import ejercicio6.modelo.Pelicula;
import ejercicio6.service.XmlSampleService;

public class App {

	public static void main(String[] args) {
		XmlSampleService xml=new XmlSampleService();
		
		List<Pelicula>peliculas=Pelicula.createRandomList(5);
		xml.escribirFicheroPeliculas(peliculas, "c:/temporal/peliculas.xml");
	}

}
