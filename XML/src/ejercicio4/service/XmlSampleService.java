package ejercicio4.service;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ejercicio4.modelo.Edicion;
import ejercicio4.modelo.Libro;

public class XmlSampleService {

	public void crearXmlLibros(List<Libro> libros, String ruta) {

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();

			Document xml = builder.newDocument();

			Element librosTag = xml.createElement("libros");
			xml.appendChild(librosTag);

			for (Libro libro : libros) {
				Element libroTag = xml.createElement("libro");
				libroTag.setAttribute("isbn", libro.getIsbn().toString());
				librosTag.appendChild(libroTag);

				Element titulo = xml.createElement("titulo");
				titulo.setTextContent(libro.getTitulo());
				libroTag.appendChild(titulo);

				Element autores = xml.createElement("autores");
				libroTag.appendChild(autores);

				for (int i = 0; i < libro.getAutores().size(); i++) {
					Element autor = xml.createElement("autor");
					autor.setTextContent(libro.getAutores().get(i));
					autores.appendChild(autor);
				}

				Element ediciones = xml.createElement("ediciones");
				libroTag.appendChild(ediciones);

				List<Edicion> edicionesLista = libro.getEdiciones();
				for (int i = 0; i < edicionesLista.size(); i++) {
					Element edicion = xml.createElement("edicion");

					Element anho = xml.createElement("año");
					anho.setTextContent(edicionesLista.get(i).getAño().toString());
					edicion.appendChild(anho);
					Element editorial = xml.createElement("editorial");
					editorial.setTextContent(edicionesLista.get(i).getEditorial());
					edicion.appendChild(editorial);
					ediciones.appendChild(edicion);
				}

			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(xml);
			File file = new File(ruta);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);

		} catch (ParserConfigurationException | TransformerException e) {

			e.printStackTrace();
		}

	}
}