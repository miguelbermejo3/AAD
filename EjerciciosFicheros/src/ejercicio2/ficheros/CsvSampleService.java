package ejercicio2.ficheros;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ejercicio5.CityApiRest;
import ejercicio5.modelo.City;


public class CsvSampleService {

	public CsvSampleService() {

	}

	public void escribirCsvAsignatura(String ruta)  {
		CityApiRest services = new CityApiRest();
		List<City> ciudades;
		try {
			ciudades = leerCsvCiudad(ruta);
			for (City city : ciudades) {
				services.createCity(city);
				
			}
		} catch (FicheroException e) {
			
			e.printStackTrace();
		}
		
		//}
		
		// writer.write("Hola clase"); 

			}
		
	

	public List<City> leerCsvCiudad(String ruta) throws FicheroException {

		List<City> ciudades = new ArrayList<City>();
		File file = new File(ruta);
		Scanner sc = null;
		try {
				
			sc = new Scanner(file);
			while (sc.hasNext()) {
				String line = sc.nextLine();
				City ciudad = new City();
				String[] campos = line.split("	");

				ciudad.setDescripcion(campos[0]);
				ciudad.setCountryId((long) Integer.parseInt(campos[1]));

				ciudades.add(ciudad);
			}

			return ciudades;
		}

		catch (FileNotFoundException e) {
			throw new FicheroException("No existe el fichero en la ruta indicada" + e);
		} finally {
			if (sc != null) {
				sc.close();
			}

		}
	}

}
