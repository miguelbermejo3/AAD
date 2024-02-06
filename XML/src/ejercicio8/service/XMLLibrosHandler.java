package ejercicio8.service;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ejercicio8.modelo.Edicion;
import ejercicio8.modelo.Libro;

public class XMLLibrosHandler extends DefaultHandler {

	private Boolean openTag;
	private String texto;
	private List<Libro> libros;
	private Libro libro;
	private Edicion edicion;
	private List<Edicion> ediciones;
	
	

	public XMLLibrosHandler() {

		openTag = true;
		texto = "";
		libros = new ArrayList<Libro>();

	
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		super.startElement(uri, localName, qName, attributes);

		openTag = true;
		texto = "";

		if (qName.equals("libro")) {
			libro = new Libro();
			libros.add(libro);
			String isbn = attributes.getValue("isbn");
			libro.setIsbn(Integer.parseInt(isbn));

		}  else if (qName.equals("edicion")){
			edicion = new Edicion();
			libro.getEdiciones().add(edicion);
			

		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		super.endElement(uri, localName, qName);

		openTag = false;

		if (qName.equals("titulo")) {
			libro.setTitulo(texto);
		}
		else if(qName.equals("autor")) {
			libro.getAutores().add(texto);
			
		}
		else if(qName.equals("año")) {
			edicion.setAño(Integer.parseInt(texto));
		}
		else if(qName.equals("editorial")) {
			edicion.setEditorial(texto);
			
		}
		

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		super.characters(ch, start, length);
		if (openTag) {
			texto += new String(ch, start, length);
		}
	}

	public List<Libro> getLibros() {
		return libros;
	}

}
