package ejercicio1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejercicio01.modelo.Pelicula;
import ejercicio01.service.PeliculaService;
import ejercicio01.service.PeliculasServiceException;

@RestController
public class PeliculaServiceApi {

	@PostMapping("/peliculas")
	public List<Pelicula> getPeliculas(@RequestParam int id){
		
		PeliculaService ps=new PeliculaService();
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		try {
			peliculas = ps.consultarPeliculas(id);
		} catch (PeliculasServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return peliculas;
		
		
		
		
		
	}

}
