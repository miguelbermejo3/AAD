package ejercicio10.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ejemploHandle.service.CursosXMLException;
import ejercicio10.modelo.Libro;
import ejercicio10.modelo.Libros;

public class XMLJacksonService {

	public void escribirXMLLibros(String pathName, List<Libro> libro) throws CursosXMLException {

		try {
			Libros libros = new Libros();
			libros.setLibros(libro);
			XmlMapper mapper = new XmlMapper();

			File file = new File(pathName);
			mapper.writeValue(file, libros);
		} catch (IOException e) {

			System.out.println("error al escribir xml de libros: " + e.getMessage());
			throw new CursosXMLException("Error escribiendo xml", e);
		}

	}

	public List<Libro> leerXMLLibros(String pathName) {

		Libros libro=null;
		try {
			
		
			XmlMapper mapper = new XmlMapper();

			File file = new File(pathName);
			 libro=mapper.readValue(file, Libros.class);
			

		} catch (IOException e) {

			e.printStackTrace();
		}
		return libro.getLibros();
		

	}

}
