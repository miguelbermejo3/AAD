package ejercicio2.ficheros;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ejercicio5.CityApiRest;
import ejercicio5.modelo.City;
import ejercicio5.service.ServerErrorException;

public class CsvSampleService {

	public CsvSampleService() {

	}



	public void importarCiudadCSV(String ruta) throws FicheroException {
		Scanner sc=null;
		try {
			File file = new File(ruta);
			CityApiRest services = new CityApiRest();
	
			 sc = new Scanner(file);
			while (sc.hasNext()) {
				City ciudad = new City();
				String linea = sc.nextLine();
				
				String[] campos = linea.split("\t");

				ciudad.setDescripcion(campos[0]);
				ciudad.setCountryId((long) Integer.parseInt(campos[1]));

				services.createCity(ciudad);
				}
			sc.close();

			
		}

		catch (FileNotFoundException e) {
			throw new FicheroException("fichero no encontrado",e);
	}finally {
		try {
			sc.close();
		}catch(Exception ignore) {
			
		}
	}

	}
	}
