package ejercicio5.cliente;

import ejercicio5.modelo.City;

public class Test {

	public static void main(String[] args) {
		CityClienteRest cliente=new CityClienteRest("http://localhost:8080",80);
		City ciudad= new City();
		
		ciudad.setCountryId((long) 90);
		ciudad.setDescripcion("miciudadmodificada");
		ciudad.setId((long) 990);
		
		cliente.updateCity(ciudad);
		
		
		
		System.out.println(ciudad);
	}

}
