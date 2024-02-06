package ejercicio7.app;

import ejercicio7.service.XmlSampleService;

public class App {

	public static void main(String[] args) {

		XmlSampleService service = new XmlSampleService();
		System.out.println(service.leerXmlPeliculas("c:/temporal/xmlPeliculas.xml"));
	}

}
