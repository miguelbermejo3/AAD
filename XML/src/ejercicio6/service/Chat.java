package ejercicio6.service;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ejercicio6.modelo.Pelicula;
import ejercicio6.modelo.Persona;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
public class Chat {


	

	    public void generarXML(List<Pelicula> peliculas, String rutaArchivo) {
	        try {
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            Document document = builder.newDocument();

	            // Elemento raíz
	            Element peliculasElement = document.createElement("peliculas");
	            document.appendChild(peliculasElement);

	            // Crear elementos para cada película
	            for (Pelicula pelicula : peliculas) {
	                Element peliculaElement = document.createElement("pelicula");

	                Element tituloElement = document.createElement("titulo");
	                tituloElement.appendChild(document.createTextNode(pelicula.getTitulo()));
	                peliculaElement.appendChild(tituloElement);

	                Element duracionElement = document.createElement("duracion");
	                duracionElement.appendChild(document.createTextNode(String.valueOf(pelicula.getDuracion())));
	                peliculaElement.appendChild(duracionElement);

	                Element anoElement = document.createElement("año");
	                anoElement.appendChild(document.createTextNode(String.valueOf(pelicula.getAño())));
	                peliculaElement.appendChild(anoElement);

	                // Agregar elementos para dirección y producción
	                agregarArtistaElement(document, peliculaElement, pelicula.getDireccion(), Persona.DIRECCION);
	                agregarArtistaElement(document, peliculaElement, pelicula.getProduccion(), Persona.PRODUCCION);

	                // Agregar elementos para actores
	                for (Persona actor : pelicula.getActores()) {
	                    agregarArtistaElement(document, peliculaElement, actor, Persona.INTERPRETACION);
	                }

	                peliculasElement.appendChild(peliculaElement);
	            }

	            // Escribir el contenido en un archivo
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource source = new DOMSource(document);

	            FileOutputStream outputStream = new FileOutputStream(new File(rutaArchivo));
	            StreamResult result = new StreamResult(outputStream);
	            transformer.transform(source, result);

	            System.out.println("XML generado y guardado en: " + rutaArchivo);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private static void agregarArtistaElement(Document document, Element peliculaElement, Persona artista, String tipo) {
	        if (artista != null) {
	            Element artistaElement = document.createElement("artista");
	            artistaElement.setAttribute("tipo", tipo);

	            Element nombreElement = document.createElement("nombre");
	            nombreElement.appendChild(document.createTextNode(artista.getNombre()));
	            artistaElement.appendChild(nombreElement);

	            Element nacionalidadElement = document.createElement("nacionalidad");
	            nacionalidadElement.appendChild(document.createTextNode(artista.getNacionalidad()));
	            artistaElement.appendChild(nacionalidadElement);

	            peliculaElement.appendChild(artistaElement);
	        }
	    }
	
}

