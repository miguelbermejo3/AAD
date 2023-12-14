package ejemplos;

import java.io.File;

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

public class XmlSampleService {

	public XmlSampleService() {

	}

	public void crearXmlCursos(String ruta) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
 
			Document xml = builder.newDocument();
 
			Element root = xml.createElement("cursos");
			xml.appendChild(root);
 
			Element cursoTag = xml.createElement("curso");
			root.appendChild(cursoTag);
 
			Element nombreTag = xml.createElement("nombre");
			nombreTag.setTextContent("Programacion");
			cursoTag.appendChild(nombreTag);
 
			Element dniTag = xml.createElement("dni");
			dniTag.setTextContent("1234D");
			cursoTag.appendChild(dniTag);
 
			Element horasTag = xml.createElement("horas");
			horasTag.setTextContent("8");
			cursoTag.appendChild(horasTag);
 
			Element alumnosTag = xml.createElement("alumnos");
			cursoTag.appendChild(alumnosTag);
 
			Element alumnoTag = xml.createElement("alumno");
			alumnosTag.appendChild(alumnoTag);
			alumnoTag.setTextContent("Miguel Bermejo");
			alumnoTag.setAttribute("dni", "1234Z");
 
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
