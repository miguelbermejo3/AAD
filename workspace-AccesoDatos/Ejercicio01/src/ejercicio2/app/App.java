package ejercicio2.app;

import java.util.Map;

import ejercicio2.modelo.Cliente;
import ejercicio2.service.ClienteService;
import ejercicio2.service.ClienteServiceException;

public class App {

	public static void main(String[] args) {

		ClienteService cs = new ClienteService();
		Map<String, Cliente> clientes;
		try {
			clientes = cs.consultarClientes();
			System.out.println(clientes.get("MARILYN.ROSS@sakilacustomer.org"));
		} catch (ClienteServiceException e) {

			e.printStackTrace();
		}

	}

}
