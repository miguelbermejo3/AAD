package ejercicio1.ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ejercicio01.modelo.Pelicula;
import ejercicio01.service.PeliculaService;
import ejercicio01.service.PeliculasServiceException;



public class CsvSampleService {

	public CsvSampleService() {
		
	}
	
	public void escribirCsvPelicula(String ruta) throws FicheroException,PeliculasServiceException{
		PeliculaService services= new PeliculaService();
		List<Pelicula>peliculas= services.consultarPeliculas(100);
		File file= new File(ruta);
		FileWriter writer= null;
		try {
			writer= new FileWriter(file);
			for (Pelicula pelicula : peliculas) {
				writer.write(pelicula.getId()+";");
				writer.write(pelicula.getLongitud()+";");
				writer.write(pelicula.getNombre()+"\n");
			}
		}catch(IOException e ) {
			throw new FicheroException("Error escribiendo CSV"+e);
		}finally {
			if(writer!=null) {
				try {
					writer.close();
				}catch(Exception ignore) {}
			}
		}
	}

}
