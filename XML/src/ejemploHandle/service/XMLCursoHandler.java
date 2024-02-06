package ejemploHandle.service;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ejemploHandle.modelo.Alumno;
import ejemploHandle.modelo.Curso;

public class XMLCursoHandler extends DefaultHandler {

	private Boolean openTag;
	private String texto;
	private List<Curso> cursos;
	private Curso curso;
	private Alumno alumn;

	public XMLCursoHandler() {
		openTag = false;
		texto = null;
		cursos = new ArrayList<Curso>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		super.startElement(uri, localName, qName, attributes);
		openTag = true;
		texto = "";

		if (qName.equals("curso")) {
			curso = new Curso();
			cursos.add(curso);
		} else if (qName.equals("alumno")) {
			alumn = new Alumno();
			curso.getAlumnos().add(alumn);
			String dni = attributes.getValue("dni");
			alumn.setDni(dni);
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		super.endElement(uri, localName, qName);
		openTag = false;

		if (qName.equals("nombre")) {
			curso.setNombre(texto);
		} else if (qName.equals("horas")) {
			curso.setHora(Integer.parseInt(texto));
		}

		else if (qName.equals("alumno")) {
			alumn.setNombre(texto);
		}

	}

	@Override
	public void characters(char[] caracter, int start, int length) throws SAXException {

		super.characters(caracter, start, length);
		if (openTag) {
			texto += new String(caracter, start, length);
		}

	}

	public List<Curso> getCursos() {
		return cursos;
	}

}
