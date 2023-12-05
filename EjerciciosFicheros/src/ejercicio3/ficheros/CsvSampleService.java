package ejercicio3.ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvSampleService {

	public void convertirCsv(String ficheroEntrada, String ficheroSalida) throws FicheroException {
		List<String[]> filas = leerCsv(ficheroEntrada);
		escribirCsv(filas, ficheroSalida);
	}

	public List<String[]> leerCsv(String ruta) throws FicheroException {
		List<String[]> filas = new ArrayList<>();
		File file = new File(ruta);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				filas.add(campos);
			}
			return filas;
		} catch (IOException e) {
			throw new FicheroException("error leyendo Csv: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

	public void escribirCsv(List<String[]> filas, String ficheroSalida) throws FicheroException {

		FileWriter writer = null;
		try {
			writer = new FileWriter(ficheroSalida);
			for (String[] campos : filas) {
				StringBuilder nuevaLinea = new StringBuilder();
				for (int i = 0; i < campos.length; i++) {
					nuevaLinea.append(campos[i]);
					if (i < campos.length - 1) {
						nuevaLinea.append(",");
					}
				}
				writer.write(nuevaLinea.toString() + "\n");
			}

		} catch (IOException e) {
			throw new FicheroException("Error escribiendo CSV: " + e.getMessage());
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception ignore) {
				}
			}

		}

	}

}
