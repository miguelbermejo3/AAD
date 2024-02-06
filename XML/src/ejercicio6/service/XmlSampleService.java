package ejercicio6.service;

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

import ejercicio6.modelo.Pelicula;
import ejercicio6.modelo.Persona;

public class XmlSampleService {

	public void escribirFicheroPeliculas(List<Pelicula> peliculasLista, String ruta) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			Document xml = builder.newDocument();

			Element peliculas = xml.createElement("peliculas");
			xml.appendChild(peliculas);

			for (Pelicula peliculaDeLista : peliculasLista) {
				Element pelicula = xml.createElement("pelicula");
				peliculas.appendChild(pelicula);
				Element titulo = xml.createElement("titulo");
				titulo.setTextContent(peliculaDeLista.getTitulo());
				pelicula.appendChild(titulo);
				Element duracion = xml.createElement("duracion");
				duracion.setTextContent(peliculaDeLista.getDuracion().toString());
				pelicula.appendChild(duracion);
				Element año = xml.createElement("anho");
				año.setTextContent(peliculaDeLista.getAño().toString());
				pelicula.appendChild(año);

				agregarArtistaElement(xml, pelicula, peliculaDeLista.getDireccion(), Persona.DIRECCION);
				agregarArtistaElement(xml, pelicula, peliculaDeLista.getProduccion(), Persona.PRODUCCION);

				for (Persona actor : peliculaDeLista.getActores()) {
					agregarArtistaElement(xml, pelicula, actor, Persona.INTERPRETACION);
				}

				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();

				DOMSource source = new DOMSource(xml);
				File file = new File(ruta);
				StreamResult result = new StreamResult(file);
				transformer.transform(source, result);
				Element artistas = xml.createElement("artistas");
				pelicula.appendChild(artistas);

			}

		} catch (ParserConfigurationException | TransformerException e) {

			e.printStackTrace();
		}

	}

	public void agregarArtistaElement(Document documento, Element elemento, Persona artista, String tipo) {

		if (artista != null) {
			Element artistaElement = documento.createElement("artista");
			artistaElement.setAttribute("tipo", tipo);
			Element nombreArtista = documento.createElement("nombre");
			nombreArtista.appendChild(documento.createTextNode(artista.getNombre()));
			artistaElement.appendChild(nombreArtista);

			Element nacionalidadArtista = documento.createElement("nacionalidad");
			nacionalidadArtista.appendChild(documento.createTextNode(artista.getNacionalidad()));
			artistaElement.appendChild(nacionalidadArtista);

			elemento.appendChild(artistaElement);
		}

	}

}
