package ejercicio4.service;

import java.util.HashMap;
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
	public  Cliente consultarCliente(@RequestParam String correo) throws ClienteNotFoundException {

		ClienteService cs = new ClienteService();
		Cliente c = new Cliente();
		Map<String, Cliente> clientes = new HashMap<>();
		try {
			clientes = cs.consultarClientes();

			c = clientes.get(correo);

			if (c == null) {
				throw new ClienteNotFoundException();
			} 

		} catch (ClienteServiceException e) {

			e.printStackTrace();
		}
		return c;

	}

}
