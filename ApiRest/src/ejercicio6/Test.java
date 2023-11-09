package ejercicio6;

import ejercicio6.client.CiudadErrorException;
import ejercicio6.client.CiudadNoEncontradaException;
import ejercicio6.client.CiudadesClient;
import ejercicio6.client.CiudadesClientImpl;
import ejercicio6.modelo.Ciudad;

public class Test {


	public static void main(String[] args) {
		String url = "http://localhost:8080";
		
		CiudadesClient cliente = new CiudadesClientImpl(url,3000);
		Ciudad ciudad = new Ciudad();
		ciudad.setDescripcion("Samarcanda");
		ciudad.setCountryId(87L);
		try {
			System.out.println("\n>>> Test consulta ciudad existente Hanoi:::");
			System.out.println(cliente.getCity(201L));

			System.out.println("\n>>> Test consulta ciudades existentes Lancaster-Newcastle:::");
			System.out.println(cliente.getCities("cas"));

			System.out.println("\n>>> Test crear ciudad nueva Samarcanda:::");
			ciudad = cliente.createCity(ciudad);
			System.out.println(ciudad);

			System.out.println("\n>>> Test modificar ciudad Samarcanda por Babilonia (conservando país):::");
			ciudad.setCountryId(null);
			ciudad.setDescripcion("Babilonia");
			ciudad = cliente.updateSelectiveCity(ciudad);
			System.out.println(ciudad);

			System.out.println("\n>>> Test modificar ciudad Babilonia por Samarcanda (borrando pa�s):::");
			ciudad.setCountryId(null);
			ciudad.setDescripcion("Samarcanda");
			cliente.updateCity(ciudad);
			System.out.println(cliente.getCity(ciudad.getId()));

			System.out.println("\n>>> Test borrar ciudad Samarcanda:::");
			cliente.deleteCity(ciudad.getId());
		} catch (CiudadNoEncontradaException | CiudadErrorException e) {
			System.out.println("El test no se ha superado correctamente. Revisa tu código.");
			e.printStackTrace();
		}
		try {
			ciudad = cliente.getCity(ciudad.getId()); // Debe saltar NotFoundException
			System.out.println("Test de borrado err�neo: la ciudad sigue existiendo: " + ciudad);
		} catch (CiudadNoEncontradaException e) {
			System.out.println(e.getMessage());
			System.out.println("Test superado correctamente");
		} catch (CiudadErrorException e) {
			System.out.println("El test no se ha superado correctamente. Revisa tu código.");
			e.printStackTrace();
		}

	}

}
