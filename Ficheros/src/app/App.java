package app;

import ficheros.CsvSampleService;
import ficheros.FicheroException;

public class App {

	public App() {
		
	}
	
	public static void main(String[] args) {
		CsvSampleService serviceCsv=new CsvSampleService();
		try {
			serviceCsv.escribirCsvAsignatura("c:/temporal/asignaturas.txt");
		} catch (FicheroException e) {
			
			e.printStackTrace();
		}
	}

}
