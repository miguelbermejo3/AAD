package ejercicio3.app;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import ejercicio3.modelo.Pago;
import ejercicio3.service.PagosException;
import ejercicio3.service.PagosService;

public class App {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("introduzca el correo");
		String correo = scanner.nextLine();

		PagosService ps = new PagosService();

		Map<String, List<Pago>> pagos;
		try {
			pagos = ps.consulta();
			System.out.println(pagos.get(correo));
		} catch (PagosException e) {
			
			e.printStackTrace();
		}
		

		scanner.close();

	}

}
