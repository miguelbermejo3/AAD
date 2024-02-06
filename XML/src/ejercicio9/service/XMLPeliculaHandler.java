package ejercicio9.service;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ejercicio9.modelo.Pelicula;
import ejercicio9.modelo.Persona;

public class XMLPeliculaHandler extends DefaultHandler {

	private Boolean openTag;
	private String texto;
	private Pelicula pelicula;
	private List<Pelicula> peliculas;
	private Persona persona;

	public XMLPeliculaHandler() {
		openTag = true;
		texto = "";
		peliculas = new ArrayList<Pelicula>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		super.startElement(uri, localName, qName, attributes);
		openTag = true;
		texto = "";

		if (qName.equals("pelicula")) {
			pelicula = new Pelicula();
			pelicula.setDireccion(persona);
			peliculas.add(pelicula);

		} else if (qName.equals("artista")) {
			persona = new Persona();
			if (attributes.getValue("tipo").equals(Persona.DIRECCION)) {
				pelicula.setDireccion(persona);

			}
			if (attributes.getValue("tipo").equals(Persona.INTERPRETACION)) {
				pelicula.setDireccion(persona);
			}
			if (attributes.getValue("tipo").equals(Persona.PRODUCCION)) {
				pelicula.getActores().add(persona);
			}

		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		super.endElement(uri, localName, qName);
		openTag = false;

		if (qName.equals("titulo")) {
			pelicula.setTitulo(texto);
		} else if (qName.equals("duracion")) {
			pelicula.setDuracion(Integer.parseInt(texto));
		} else if (qName.equals("año")) {
			pelicula.setAño(Integer.parseInt(texto));
		}

		else if (qName.equals("nombre")) {
			persona.setNombre(texto);
		} else if (qName.equals("nacionalidad")) {
			persona.setNacionalidad(texto);
		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		super.characters(ch, start, length);
		if (openTag) {
			texto += new String(ch, start, length);
		}
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

}
