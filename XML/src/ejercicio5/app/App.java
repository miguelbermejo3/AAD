package ejercicio5.app;

import ejercicio5.service.XmlSampleService;

public class App {

	public static void main(String[] args) {
		
		
		XmlSampleService service= new XmlSampleService();
		System.out.println(service.leerXmlLibros("c:/temporal/xmlLibros.xml"));
		
		
		
		
		
		
		
		
		
	}

}
