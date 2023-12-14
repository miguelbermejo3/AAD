package ejercicio4.app;

import java.util.List;


import ejercicio4.modelo.Libro;
import ejercicio4.service.XmlSampleService;

public class App {
public static void main(String[] args) {
	
	List<Libro>libros= Libro.createRandomList(5);
	
	XmlSampleService xml= new XmlSampleService();
	xml.crearXmlLibros(libros, "c:/temporal/libros.xml");
	
	
}

}
