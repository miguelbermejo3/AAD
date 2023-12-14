package ejercicio2.app;

import ejercicio2.ficheros.CsvSampleService;
import ejercicio2.ficheros.FicheroException;

public class App {

	public static void main(String[] args) {
		CsvSampleService csvService= new CsvSampleService();
		
		try {
			csvService.importarCiudadCSV("c:/temporal/ciudades.csv");
		} catch (FicheroException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
