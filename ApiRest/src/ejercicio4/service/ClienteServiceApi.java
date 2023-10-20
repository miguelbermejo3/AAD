package ejercicio4.service;




import java.util.Collection;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ejercicio2.modelo.Cliente;
import ejercicio2.service.ClienteService;
import ejercicio2.service.ClienteServiceException;

@RestController
public class ClienteServiceApi {


	@PostMapping("/peliculas")
	public Map<String, Cliente> consultarCliente(@RequestParam String correo) throws ClienteServiceException {
		
		ClienteService cs=new ClienteService();
		Map<String,Cliente>clientes=cs.consultarClientes();
		Collection<Cliente>keys=clientes.values();
		for (Cliente cliente : keys) {
			if(correo.equals(cliente.getCorreo())) {
				return clientes;
			}
			else {
				throw new ClienteNotFoundException();
			}
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
