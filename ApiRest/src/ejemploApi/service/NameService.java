package ejemploApi.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameService {

	
	@GetMapping("/nombre")  //se pone el nombre que queramos
	//devuelve nuestro string
	public String getNombre() {
		return "MIGUEL BERMEJO";
	}
	
	@GetMapping("/cuadrado") //devuelve el cuadrado, poniendo?nombrevariable=
	public int cuadrado(@RequestParam int numero) {
		return numero*numero;
	}
	
	@GetMapping("/potencia/{numero}/{potencia}")//devuelve la potencia, poniendo?numero=&potencia=
	public Double potencia(@PathVariable Double numero,@PathVariable Double potencia) {
		return Math.pow(numero, potencia);
	}
	
	
	
}
