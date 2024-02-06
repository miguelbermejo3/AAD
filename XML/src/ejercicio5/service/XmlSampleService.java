package ejercicio5.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ejercicio4.modelo.Edicion;
import ejercicio4.modelo.Libro;

public class XmlSampleService {

	public XmlSampleService() {

	}

	public List<Libro> leerXmlLibros(String ruta) {

		List<Libro> libros = null;
		try {
			libros = new ArrayList<>();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document xml = builder.parse(new File(ruta));
			Element root = xml.getDocumentElement();

			NodeList listaLibros = root.getElementsByTagName("libro");
			for (int i = 0; i < listaLibros.getLength(); i++) {

				Element libroTag = (Element) listaLibros.item(i);
				Libro libro = new Libro();
				String isbn = libroTag.getAttribute("isbn");
				libro.setIsbn(Integer.parseInt(isbn));

				Element titulo = (Element) libroTag.getElementsByTagName("titulo").item(0);
				String nombre = titulo.getTextContent();
				libro.setTitulo(nombre);

				Element autores = (Element) libroTag.getElementsByTagName("autores").item(0);

				NodeList listaAutores = autores.getElementsByTagName("autor");
				List<String> ListaAutoresFinal = new ArrayList<>();
				for (int j = 0; j < listaAutores.getLength(); j++) {
					Element autor = (Element) autores.getElementsByTagName("autor").item(j);
					String autorNombre = autor.getTextContent();
					ListaAutoresFinal.add(autorNombre);

				}
				libro.setAutores(ListaAutoresFinal);

				Element ediciones = (Element) libroTag.getElementsByTagName("ediciones").item(0);
				NodeList listaEdiciones = ediciones.getElementsByTagName("edicion");
				List<Edicion> edicionesLista = new ArrayList<>();
				for (int z = 0; z < listaEdiciones.getLength(); z++) {

					Element edicion = (Element) ediciones.getElementsByTagName("edicion").item(z);
					Edicion ed = new Edicion();

					Element anho = (Element) edicion.getElementsByTagName("año").item(0);
					String año = anho.getTextContent();
					ed.setAño(Integer.parseInt(año));

					Element editorial = (Element) edicion.getElementsByTagName("editorial").item(0);
					String editorialFinal = editorial.getTextContent();
					ed.setEditorial(editorialFinal);

					edicionesLista.add(ed);

				}

				libro.setEdiciones(edicionesLista);

				libros.add(libro);
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {

			e.printStackTrace();
		}
		return libros;

	}

}
