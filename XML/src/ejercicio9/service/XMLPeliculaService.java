package ejercicio9.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import ejercicio9.modelo.Pelicula;

public class XMLPeliculaService {

	public List<Pelicula> leerPeliculas(String filePath) throws PeliculasXMLException {

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();

			XMLPeliculaHandler handler = new XMLPeliculaHandler();
			File file = new File(filePath);
			parser.parse(file, handler);

			return handler.getPeliculas();

		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println("error leyendo xml" + e.getMessage());
			throw new PeliculasXMLException();

		}

	}
}
