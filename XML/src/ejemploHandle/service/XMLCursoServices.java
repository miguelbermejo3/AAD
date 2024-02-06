package ejemploHandle.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import ejemploHandle.modelo.Curso;

public class XMLCursoServices {

	public List<Curso> leerCursos(String filePath) throws CursosXMLException {

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();

			XMLCursoHandler handler = new XMLCursoHandler();
			File file = new File(filePath);
			parser.parse(file, handler);
			return handler.getCursos();

		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println("error leyendo xml" + e.getMessage());
			throw new CursosXMLException();

		}
		
		
	}

}
