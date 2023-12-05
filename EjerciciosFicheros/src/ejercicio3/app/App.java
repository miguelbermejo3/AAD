package ejercicio3.app;

import ejercicio3.ficheros.CsvSampleService;
import ejercicio3.ficheros.FicheroException;

public class App {

	public static void main(String[] args) {
		
		
		
		CsvSampleService service= new CsvSampleService();
		try {
			service.convertirCsv("c:/clientes.csv","c:/temporal/clientes.txt" );
			System.out.println("conversión completa");
		}catch(FicheroException e) {
			System.out.println("Error : "+e.getMessage());
		}
		
		
		
	}

}
