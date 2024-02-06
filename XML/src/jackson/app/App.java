package jackson.app;



import java.util.ArrayList;
import java.util.List;


import ejemploHandle.service.CursosXMLException;
import ejercicio10.modelo.Edicion;
import ejercicio10.modelo.Libro;
import ejercicio10.service.XMLJacksonService;



public class App {

	public static void main(String[] args) {
		testCrearXMLCursoJackson();
	}

	private static void testCrearXMLCursoJackson() {
		
		List<Libro>libros= new ArrayList<>();
		Libro libro= new Libro();
		libro.setTitulo("klnjwrfvg");
		
		List<Edicion>ediciones= new ArrayList<>(); 
		Edicion e= new Edicion();
		e.setAño(1999);
		e.setEditorial("kjswrng");
		ediciones.add(e);
		libro.setEdiciones(ediciones);
		List<String>autores= new ArrayList<>();
		autores.add("miguel");
		autores.add("adfdatg");
		libro.setAutores(autores);
		
		Libro libro2= new Libro();
		libro2.setTitulo("klnjwrfvg");
		
		List<Edicion>ediciones2= new ArrayList<>(); 
		Edicion e2= new Edicion();
		e2.setAño(1999);
		e2.setEditorial("kjswrng");
		ediciones.add(e2);
		libro2.setEdiciones(ediciones2);
		List<String>autores2= new ArrayList<>();
		autores2.add("miguel");
		autores2.add("adfdatg");
		libro2.setAutores(autores2);
		
		libros.add(libro2);
		libros.add(libro);
		
		XMLJacksonService service= new XMLJacksonService ();
		try {
			service.escribirXMLLibros("c:/temporal/librosJackson.xml",libros);
			System.out.println("creado correctamente");
		} catch (CursosXMLException ex) {
			
			ex.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	
}
