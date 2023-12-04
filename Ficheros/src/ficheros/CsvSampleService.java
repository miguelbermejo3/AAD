package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Asignatura;
import service.AsignaturaService;

public class CsvSampleService {

	public CsvSampleService() {

	}

	public void escribirCsvAsignatura(String ruta) throws FicheroException {
		AsignaturaService services = new AsignaturaService();
		List<Asignatura> asignaturas = services.consultarAsignatura();
		File file = new File(ruta);
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);// true para que no machaque y lo añada abajo
			for (Asignatura asignatura : asignaturas) {
				/*
				 * writer.write(asignatura.getId()+";");
				 * writer.write(asignatura.getNombre()+";");
				 * writer.write(asignatura.getCiclo()+"\n");
				 */
				writer.write(asignatura.toCsv() + "\n");

			}
			//writer.write("Hola clase");

		} catch (IOException e) {
			throw new FicheroException("Error escribiendo CSV" + e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception ignore) {

				}

			}
		}
	}

	public List<Asignatura> leerCsvAsignatura(String ruta) throws FicheroException {

		List<Asignatura> asignaturas = new ArrayList<Asignatura>();
		File file = new File(ruta);
		Scanner sc = null;
		try {

			sc = new Scanner(file);
			while (sc.hasNext()) {
				String line = sc.nextLine();
				Asignatura a = new Asignatura();
				String[] campos = line.split(";");
				a.setId(Integer.parseInt(campos[0]));
				a.setNombre(campos[1]);
				a.setCiclo(campos[2]);
				asignaturas.add(a);
			}

			return asignaturas;
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
