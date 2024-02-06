package ejercicio10.app;




import java.util.List;

import ejemploHandle.service.CursosXMLException;

import ejercicio10.modelo.Libro;
import ejercicio10.service.XMLJacksonService;

public class App {
	
	public static void main(String[] args) {
		testCrearXMLCursoJackson();
	}
	
	private static void testCrearXMLCursoJackson() {


	
	XMLJacksonService service= new XMLJacksonService ();
	List<Libro> libros=service.leerXMLLibros("c:/temporal/librosJackson.xml");
	System.out.println(libros);
}
	
	
	 


}
