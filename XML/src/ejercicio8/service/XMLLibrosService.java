package ejercicio8.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import ejercicio8.app.LibrosXMLException;
import ejercicio8.modelo.Libro;

public class XMLLibrosService {

	
	public List<Libro> leerLibros(String filePath) throws LibrosXMLException {

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();

			XMLLibrosHandler handler = new XMLLibrosHandler();
			File file = new File(filePath);
			parser.parse(file, handler);
			
			return handler.getLibros();

			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println("error leyendo xml" + e.getMessage());
			throw new LibrosXMLException();

		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
