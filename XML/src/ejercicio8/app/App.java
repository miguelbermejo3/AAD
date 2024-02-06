package ejercicio8.app;



import java.util.List;

import ejercicio8.modelo.Libro;
import ejercicio8.service.XMLLibrosService;


public class App {

	public static void main(String[] args) {
		testLeerXMLLibroSax();
	}
	
	private static void testLeerXMLLibroSax() {
		XMLLibrosService service= new XMLLibrosService();
		
				try {
					List<Libro>libros=service.leerLibros("c:/temporal/xmlLibros.xml");
					for (Libro libro : libros) {
						System.out.println(libro);
					}
				} catch (LibrosXMLException e) {
					
					e.printStackTrace();
				}
	}

}
