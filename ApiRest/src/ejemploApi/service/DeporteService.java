package ejemploApi.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejemploApi.modelo.Deporte;

@RestController
public class DeporteService {

	@GetMapping("/deporte")
	public Deporte getDeporte(@RequestParam int id) throws DeporteNotFoundException {
		
		
		Deporte futbol=new Deporte();
		if(id==99) {
			throw new DeporteNotFoundException("no existe el deporte con id 99");
		}
		futbol.setNombre("futbol");
		futbol.setId(id);
		futbol.setAforo(22);
		
		return futbol;
	}
	
	@PostMapping("/deporte")
	public Deporte crearDeporte(@RequestBody Deporte deporte) {
		
		System.out.println("creando deporte en bbdd");
		System.out.println(deporte);
		/*if(deporte.getId()==null) {
			throw new 
		}*/
		
		deporte.setId(1);
		System.out.println("deporte creado");
		
		return deporte;
		
		
	}
	
	
	
	
	
}
