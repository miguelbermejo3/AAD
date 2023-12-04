package ejercicio1.app;


import ejercicio01.service.PeliculasServiceException;
import ejercicio1.ficheros.CsvSampleService;
import ficheros.FicheroException;



public class App {

	public static void main(String[] args) {
		CsvSampleService serviceCsv=new CsvSampleService();
		
		try {
			serviceCsv.escribirCsvPelicula("c:/temporal/peliculas.txt");
		} catch (FicheroException e) {
			
			e.printStackTrace();
		} catch (PeliculasServiceException e) {
			
			e.printStackTrace();
		}
			
		
			
		
	}

	
}
