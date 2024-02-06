package ejercicio7.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ejercicio6.modelo.Pelicula;
import ejercicio6.modelo.Persona;

public class XmlSampleService {

	public List<Pelicula> leerXmlPeliculas(String ruta) {
		List<Pelicula> peliculasFinal = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			peliculasFinal = new ArrayList<>();
			builder = factory.newDocumentBuilder();
			Document xml = builder.parse(new File(ruta));
			Element root = xml.getDocumentElement();

			NodeList listaPeliculas = root.getElementsByTagName("pelicula");

			for (int i = 0; i < listaPeliculas.getLength(); i++) {

				Element peliculaTag = (Element) listaPeliculas.item(i);
				Pelicula pelicula = new Pelicula();
				Element titulo = (Element) peliculaTag.getElementsByTagName("titulo").item(0);
				String nombre = titulo.getTextContent();
				pelicula.setTitulo(nombre);

				Element duracion = (Element) peliculaTag.getElementsByTagName("duracion").item(0);
				String duracionNumero = duracion.getTextContent();
				pelicula.setDuracion(Integer.parseInt(duracionNumero));

				Element anho = (Element) peliculaTag.getElementsByTagName("año").item(0);
				String anhoNumero = anho.getTextContent();
				pelicula.setAño(Integer.parseInt(anhoNumero));

				Element artistasTag = (Element) peliculaTag.getElementsByTagName("artistas").item(0);
				NodeList listaAutores = artistasTag.getElementsByTagName("artista");

				List<Persona> artistas = new ArrayList<>();
				for (int j = 0; j < listaAutores.getLength(); j++) {
					Persona p = new Persona();
					Element artistaTag = (Element) artistasTag.getElementsByTagName("artista").item(j);
					Element nombreTag = (Element) artistaTag.getElementsByTagName("nombre").item(0);
					Element nacionalidadTag = (Element) artistaTag.getElementsByTagName("nacionalidad").item(0);
					p.setNacionalidad(nacionalidadTag.getTextContent());
					p.setNombre(nombreTag.getTextContent());
					NamedNodeMap mapaAtributos = artistaTag.getAttributes();
					for (int x = 0; x < mapaAtributos.getLength(); x++) {
						Node atrib = mapaAtributos.item(x);
						if (atrib.getTextContent() == Persona.DIRECCION) {

							pelicula.setDireccion(p);
						} else if (atrib.getTextContent() == Persona.PRODUCCION) {
							pelicula.setProduccion(p);
						} else {
							artistas.add(p);
						}
					}

				}
				pelicula.setActores(artistas);
				peliculasFinal.add(pelicula);

			}
		} catch (ParserConfigurationException | SAXException | IOException e) {

			e.printStackTrace();
		}

		return peliculasFinal;

	}

}
